package com.example.childhealthrecord.mapper;

import com.example.childhealthrecord.entity.DiseaseEntity;
import com.example.childhealthrecord.dto.DiseaseDto;

public class DiseaseMapper {

    public static DiseaseEntity toEntity(DiseaseDto model){
        DiseaseEntity entity = new DiseaseEntity();
        entity.setName(model.getName());
        entity.setStartingDate(model.getStartingDate());
        entity.setEndingDate(model.getEndingDate());
        entity.setSymptom1(model.getSymptom1());
        entity.setSymptom2(model.getSymptom2());
        entity.setSymptom3(model.getSymptom3());

        return entity;
    }
}
