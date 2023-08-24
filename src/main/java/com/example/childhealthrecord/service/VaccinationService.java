package com.example.childhealthrecord.service;

import com.example.childhealthrecord.entity.Vaccination;
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

    public Vaccination findById(Integer id){
        return vaccinationRepository.findById(id).get();
    }

    public void save(Vaccination vaccination){
        vaccinationRepository.save(vaccination);
    }

    public int howManyMandatoryVaccinations(Integer childId){
        List<Vaccination> vaccinations = vaccinationRepository.findByChildId(childId);
        int counter = 0;

        for (Vaccination v: vaccinations) {
            if (v.getScope().equals("mandatory") && v.getStatus().name().equals("DONE")){
                counter++;
            }
        }
        return counter;
    }

    public int howManyRecommendedVaccinations(Integer childId){
        List<Vaccination> vaccinations = vaccinationRepository.findByChildId(childId);
        int counter = 0;

        for (Vaccination v: vaccinations) {
            if (v.getScope().equals("recommended") && v.getStatus().name().equals("DONE")){
                counter++;
            }
        }
        return counter;
    }
}
