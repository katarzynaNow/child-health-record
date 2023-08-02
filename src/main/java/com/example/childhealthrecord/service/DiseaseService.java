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

    public int[] daysInMonthsSick(){
        List<DiseaseEntity> diseases = diseaseRepository.findAll();
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

                int diseaseDuration = 0;

                if( d.getStartingDate().substring(2,4).equals("23") && d.getEndingDate().substring(2,4).equals("23")) {
                    if (startMonthInt == i && endMonthInt == i) {
                        diseaseDuration = endDayInt - startDayInt;
                    } else if (startMonthInt == i && (i == 4 || i == 6 || i == 9 || i == 11)) {
                        diseaseDuration = 30 - startDayInt;
                    } else if (startMonthInt == i && i == 2) {
                        diseaseDuration = 28 - startDayInt;
                    } else if (startMonthInt == i) {
                        diseaseDuration = 31 - startDayInt;
                    } else if (endMonthInt == i) {
                        diseaseDuration = endDayInt;
                    }
                    sickDaysEveryMonth[i - 1] += diseaseDuration;
                }
            }
        }
        return sickDaysEveryMonth;
    }

    public int sickDaysInYear(int[] daysInMonthsSick ){
        int sickDaysInYear = 0;

        for (int i = 0; i < daysInMonthsSick.length ; i++) {
            sickDaysInYear += daysInMonthsSick[i];
        }
        return sickDaysInYear;
    }

    public int sickDaysPercentage(int sickDaysInYear){
        int dayOfYear = LocalDate.now().getDayOfYear();
        return (sickDaysInYear * 100)/dayOfYear;
    }
}
