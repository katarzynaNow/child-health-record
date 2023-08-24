package com.example.childhealthrecord.repository;

import com.example.childhealthrecord.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer> {

    List<AppointmentEntity> findByChildId(Integer childId);
}
