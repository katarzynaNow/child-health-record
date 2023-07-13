package com.example.childhealthrecord.repository;

import com.example.childhealthrecord.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
