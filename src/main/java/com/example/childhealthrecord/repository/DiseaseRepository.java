package com.example.childhealthrecord.repository;

import com.example.childhealthrecord.entity.DiseaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiseaseRepository extends JpaRepository<DiseaseEntity, Integer> {
    List<DiseaseEntity> findByChildId(Integer childId);
}
