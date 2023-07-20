package com.example.childhealthrecord.repository;

import com.example.childhealthrecord.entity.DiseaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseRepository extends JpaRepository<DiseaseEntity, Integer> {
}
