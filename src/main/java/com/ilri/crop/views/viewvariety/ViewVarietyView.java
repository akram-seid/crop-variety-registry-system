package com.ilri.crop.views.viewvariety;

import com.ilri.crop.data.entity.Variety;
import com.ilri.crop.data.service.VarietyService;
import com.ilri.crop.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("View Variety")
@Route(value = "empty", layout = MainLayout.class)
@AnonymousAllowed
public class ViewVarietyView extends VerticalLayout {

    TextField altitude = new TextField("Min Altitude");
    Button search = new Button("Search");

    VarietyService service;
    Grid<Variety> varietyGrid = new Grid<>(Variety.class,false);
    public ViewVarietyView(VarietyService service) {
        this.service= service;

        varietyGrid.addColumn(Variety::getCropName).setHeader("Crop Name").setResizable(true);
        varietyGrid.addColumn(Variety::getVarietyName).setHeader("Variety");
        varietyGrid.addColumn(Variety::getYearRelease).setHeader("Year of release").setFlexGrow(0);
        varietyGrid.addColumn(Variety::getBreeder).setHeader("Breeder / maintainer");
        varietyGrid.addThemeVariants(GridVariant.LUMO_COLUMN_BORDERS);
        varietyGrid.addThemeVariants(GridVariant.LUMO_WRAP_CELL_CONTENT);

        HorizontalLayout layout = new HorizontalLayout();
        layout.add(altitude);
        layout.add(search);
        layout.setAlignItems(Alignment.BASELINE);
        add(layout);
      add(varietyGrid);

      search.addClickListener(buttonClickEvent -> {
          if (service.listByAltitude(Integer.parseInt(altitude.getValue())).isEmpty()){
              Notification.show("There are no crops with that property").setPosition(Notification.Position.MIDDLE);
          }else{
              varietyGrid.setItems(service.listByAltitude(Integer.parseInt(altitude.getValue())));
          }

      });
    }

}
