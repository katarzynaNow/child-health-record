package com.example.childhealthrecord.service;

import com.example.childhealthrecord.entity.DiseaseEntity;
import com.example.childhealthrecord.mapper.DiseaseMapper;
import com.example.childhealthrecord.model.DiseaseModel;
import com.example.childhealthrecord.repository.DiseaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseService {

    private final DiseaseRepository diseaseRepository;

    public DiseaseService(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    public List<DiseaseEntity> findAll() {
        return diseaseRepository.findAll();
    }

    public void saveDisease (DiseaseModel diseaseModel){
        DiseaseEntity diseaseEntity = DiseaseMapper.toEntity(diseaseModel);

        diseaseRepository.save(diseaseEntity);
    }

    public void save (DiseaseEntity disease){
        diseaseRepository.save(disease);
    }

    public void deleteById(Integer id){
        diseaseRepository.deleteById(id);
    }

    public DiseaseEntity findById(Integer id){
        return diseaseRepository.findById(id).get();
    }

}
