package com.example.childhealthrecord.service;

import com.example.childhealthrecord.model.Disease;
import com.example.childhealthrecord.model.Vaccination;
import com.example.childhealthrecord.repository.VaccinationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccinationService {

    private final VaccinationRepository vaccinationRepository;

    public VaccinationService(VaccinationRepository vaccinationRepository) {
        this.vaccinationRepository = vaccinationRepository;
    }

    public List<Vaccination> findAll() {

        return vaccinationRepository.findAll();
    }
}
