package com.example.childhealthrecord.service;

import com.example.childhealthrecord.entity.AppointmentEntity;
import com.example.childhealthrecord.entity.DiseaseEntity;
import com.example.childhealthrecord.mapper.AppointmentMapper;
import com.example.childhealthrecord.mapper.DiseaseMapper;
import com.example.childhealthrecord.model.AppointmentModel;
import com.example.childhealthrecord.model.DiseaseModel;
import com.example.childhealthrecord.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<AppointmentEntity> findAll(){
        return appointmentRepository.findAll();
    }

    public void saveAppointmentModelToEntity(AppointmentModel appointmentModel){
        AppointmentEntity appointmentEntity = AppointmentMapper.toEntity(appointmentModel);

        appointmentRepository.save(appointmentEntity);
    }

    public void save (AppointmentEntity appointment){
        appointmentRepository.save(appointment);
    }

    public void deleteById(Integer id){
        appointmentRepository.deleteById(id);
    }

    public AppointmentEntity findById(Integer id){
        return appointmentRepository.findById(id).get();
    }

    public int howManyAntibiotics(){
        List<AppointmentEntity> appointments = appointmentRepository.findAll();
        int counter = 0;
        for ( AppointmentEntity a: appointments) {
            if (a.getAntibiotic().name() == "YES"){
                counter++;
            }
        }
        return counter;
    }


}
