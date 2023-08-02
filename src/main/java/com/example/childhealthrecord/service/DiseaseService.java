package com.example.childhealthrecord.service;

import com.example.childhealthrecord.entity.DiseaseEntity;
import com.example.childhealthrecord.mapper.DiseaseMapper;
import com.example.childhealthrecord.model.DiseaseModel;
import com.example.childhealthrecord.repository.DiseaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public int[] daysInMonthsSick(){
        List<DiseaseEntity> diseases = diseaseRepository.findAll();
        int sickDaysInMonth = 0;
        int diseaseDuration = 0;
        int[] sickDaysEveryMonth = new int[12];

        for (int i = 1; i < 13; i++) {
            for (DiseaseEntity d : diseases) {
                String startDayString = d.getStartingDate().substring(8, 10);
                int startDayInt = Integer.parseInt(startDayString);

                String endDayString = d.getEndingDate().substring(8, 10);
                int endDayInt = Integer.parseInt(endDayString);

                String startMonthString = d.getStartingDate().substring(5, 7);
                int startMonthInt = Integer.parseInt(startMonthString);

                String endMonthString = d.getEndingDate().substring(5, 7);
                int endMonthInt = Integer.parseInt(endMonthString);

                if (startMonthInt == i && endMonthInt == i) {
                    diseaseDuration = endDayInt - startDayInt;
                } else if (startMonthInt == i) {
                    if ( i == 4 || i == 6 || i == 9 || i ==11) {
                        diseaseDuration = 30 - startDayInt;
                    } else if (i == 2){
                        diseaseDuration = 28 - startDayInt;
                    } else {
                        diseaseDuration = 31 - startDayInt;
                    }
                } else if (endMonthInt == i) {
                    diseaseDuration = endDayInt;
                }
                sickDaysInMonth += diseaseDuration;
            }
            sickDaysEveryMonth[i-1] = sickDaysInMonth;
        }
        return sickDaysEveryMonth;
    }
}
