package com.example.childhealthrecord.service;

import com.example.childhealthrecord.entity.AppointmentEntity;
import com.example.childhealthrecord.mapper.AppointmentMapper;
import com.example.childhealthrecord.dto.AppointmentDto;
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

    public AppointmentEntity saveAppointmentModelToEntity(AppointmentDto appointmentModel){
        AppointmentEntity appointmentEntity = AppointmentMapper.toEntity(appointmentModel);

        return appointmentRepository.save(appointmentEntity);
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
            if (a.isAntibiotic() && a.getDate().substring(2,4).equals("23")){
                counter++;
            }
        }
        return counter;
    }


}
