package com.example.childhealthrecord.repository;

import com.example.childhealthrecord.entity.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VaccinationRepository extends JpaRepository <Vaccination, Integer> {
    List<Vaccination> findByChildId(Integer childId);
}
