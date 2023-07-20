package com.example.childhealthrecord.repository;

import com.example.childhealthrecord.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
