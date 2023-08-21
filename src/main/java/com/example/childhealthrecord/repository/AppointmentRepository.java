package com.example.childhealthrecord.repository;

import com.example.childhealthrecord.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer> {

}
