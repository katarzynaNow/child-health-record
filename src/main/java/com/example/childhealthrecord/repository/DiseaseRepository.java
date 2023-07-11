package com.example.childhealthrecord.repository;

import com.example.childhealthrecord.model.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseRepository extends JpaRepository<Disease, Integer> {
}
