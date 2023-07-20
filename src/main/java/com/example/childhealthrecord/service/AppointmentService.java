package com.example.childhealthrecord.service;

import com.example.childhealthrecord.entity.Appointment;
import com.example.childhealthrecord.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> findAll(){
        return appointmentRepository.findAll();
    }

    public void save(Appointment appointment){
        appointmentRepository.save(appointment);
    }

    public void deleteById(Integer id){
        appointmentRepository.deleteById(id);
    }

    public Appointment findById(Integer id){
        return appointmentRepository.findById(id).get();
    }

}
