package com.example.childhealthrecord.service;

import com.example.childhealthrecord.entity.DiseaseEntity;
import com.example.childhealthrecord.mapper.DiseaseMapper;
import com.example.childhealthrecord.model.DiseaseModel;
import com.example.childhealthrecord.repository.DiseaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
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

    public void saveDiseaseModelToEntity(DiseaseModel diseaseModel){
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

    public int howManyDaysSickInYear(){
        List<DiseaseEntity> diseases = diseaseRepository.findAll();
        int sickDays = 0;
        int diseaseDuration = 0;

        for (DiseaseEntity d : diseases){
            String startString = d.getStartingDate().substring(8,10);
            int startInt = Integer.parseInt(startString);

            String endString = d.getEndingDate().substring(8,10);
            int endInt = Integer.parseInt(endString);

            if(startInt < endInt) {
                diseaseDuration = endInt - startInt;
            } else {
                diseaseDuration = (30 - startInt) + endInt;
            }
            sickDays += diseaseDuration;
        }
        return sickDays;
    }

    public int sickDaysPercentage(int sickDaysInYear){
        int dayOfYear = LocalDate.now().getDayOfYear();
        int sickDaysPercentage = (sickDaysInYear * 100)/dayOfYear;
        return sickDaysPercentage;
    }

}
