package com.example.childhealthrecord.mapper;

import com.example.childhealthrecord.dto.ChildProfileDto;
import com.example.childhealthrecord.dto.DiseaseDto;
import com.example.childhealthrecord.entity.ChildProfileEntity;
import com.example.childhealthrecord.entity.DiseaseEntity;

public class ChildProfileMapper {

    public static ChildProfileEntity toEntity (ChildProfileDto model){
        ChildProfileEntity entity = new ChildProfileEntity();
        entity.setName(model.getName());
        entity.setBirthDate(model.getBirthDate());
        entity.setPicture(model.getPicture());

        return entity;
    }
}
