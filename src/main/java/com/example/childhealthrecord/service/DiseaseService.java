package com.example.childhealthrecord.service;

import com.example.childhealthrecord.model.Disease;
import com.example.childhealthrecord.repository.DiseaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseService {

    private final DiseaseRepository diseaseRepository;

    public DiseaseService(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    public List<Disease> findAll() {
        return diseaseRepository.findAll();
    }

    public void save (Disease disease){
        diseaseRepository.save(disease);
    }

    public void deleteById(Integer id){
        diseaseRepository.deleteById(id);
    }

    public Disease findById(Integer id){
        return diseaseRepository.findById(id).orElse(null);
    }

}
