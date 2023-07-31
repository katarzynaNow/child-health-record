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
            String startDayString = d.getStartingDate().substring(8,10);
            int startDayInt = Integer.parseInt(startDayString);

            String endDayString = d.getEndingDate().substring(8,10);
            int endDayInt = Integer.parseInt(endDayString);

            if(startDayInt < endDayInt) {
                diseaseDuration = endDayInt - startDayInt;
            } else {
                diseaseDuration = (30 - startDayInt) + endDayInt;
            }
            sickDays += diseaseDuration;
        }
        return sickDays;
    }

    public int sickDaysPercentage(int sickDaysInYear){
        int dayOfYear = LocalDate.now().getDayOfYear();
        return (sickDaysInYear * 100)/dayOfYear;
    }

    public int howManyDaysInMonthSick(){
        List<DiseaseEntity> diseases = diseaseRepository.findAll();
        int sickDaysInMonth = 0;
        int diseaseDuration = 0;

        for (DiseaseEntity d: diseases){
            String startDayString = d.getStartingDate().substring(8,10);
            int startDayInt = Integer.parseInt(startDayString);

            String endDayString = d.getEndingDate().substring(8,10);
            int endDayInt = Integer.parseInt(endDayString);

            String startMonthString = d.getStartingDate().substring(5,7);
            int startMonthInt = Integer.parseInt(startMonthString);

            String endMonthString = d.getEndingDate().substring(5,7);
            int endMonthInt = Integer.parseInt(endMonthString);

            if(startMonthInt == 1 && endMonthInt == 1) {
                diseaseDuration = endDayInt - startDayInt;
            } else if(startMonthInt == 1) {
                diseaseDuration = 30 - startDayInt;
            } else if (endMonthInt == 1){
                diseaseDuration = endDayInt;
            }
            sickDaysInMonth += diseaseDuration;
        }

        return sickDaysInMonth;
    }

}
