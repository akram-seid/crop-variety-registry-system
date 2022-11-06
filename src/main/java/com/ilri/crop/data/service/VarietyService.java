package com.ilri.crop.data.service;

import com.ilri.crop.data.entity.Variety;
import com.ilri.crop.data.repository.VarietyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VarietyService {

    VarietyRepository varietyRepository;

    public VarietyService(VarietyRepository varietyRepository) {
        this.varietyRepository = varietyRepository;
    }


    public Variety save(Variety variety){
        return varietyRepository.insert(variety);
    }

    public List<Variety> listAll(){
        return varietyRepository.findAll();
    }
    public List<Variety> listByAltitude(int i){
        return varietyRepository.findByMinAltitude(i);
    }
}
