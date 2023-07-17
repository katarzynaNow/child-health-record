package com.example.childhealthrecord.repository;

import com.example.childhealthrecord.model.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationRepository extends JpaRepository <Vaccination, Integer> {
}
