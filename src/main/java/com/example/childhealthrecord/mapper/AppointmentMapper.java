package com.example.childhealthrecord.mapper;

import com.example.childhealthrecord.entity.AppointmentEntity;
import com.example.childhealthrecord.entity.DiseaseEntity;
import com.example.childhealthrecord.model.AppointmentModel;
import com.example.childhealthrecord.model.DiseaseModel;

public class AppointmentMapper {

    public static AppointmentEntity toEntity(AppointmentModel model){
        AppointmentEntity entity = new AppointmentEntity();
        entity.setDate(model.getDate());
        entity.setDiagnosis(model.getDiagnosis());
        entity.setMedicines(model.getMedicines());
        entity.setAntibiotic(model.getAntibiotic());
        entity.setNotes(model.getNotes());
        entity.setDisease(model.getDisease());

        return entity;
    }
}
