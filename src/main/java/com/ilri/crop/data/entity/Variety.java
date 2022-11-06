package com.ilri.crop.data.entity;

import com.mongodb.BasicDBObject;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Variety {

    @Id
    private String id;
    private String cropName;
    private String varietyName;
    private BasicDBObject agronomicChar;
    private String seedRate;
    private String yearRelease;
    private String yearRegistration;
    private String breeder;



}
