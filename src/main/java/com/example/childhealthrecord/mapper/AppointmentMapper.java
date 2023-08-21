package com.example.childhealthrecord.mapper;

import com.example.childhealthrecord.entity.AppointmentEntity;
import com.example.childhealthrecord.dto.AppointmentDto;

public class AppointmentMapper {

    public static AppointmentEntity toEntity(AppointmentDto model){
        AppointmentEntity entity = new AppointmentEntity();
        entity.setDate(model.getDate());
        entity.setDiagnosis(model.getDiagnosis());
        entity.setMedicines(model.getMedicines());
        entity.setAntibiotic(model.isAntibiotic());
        entity.setNotes(model.getNotes());
        entity.setDisease(model.getDisease());

        return entity;
    }
}
