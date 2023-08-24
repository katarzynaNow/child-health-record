package com.example.childhealthrecord.service;

import com.example.childhealthrecord.dto.ChildProfileDto;
import com.example.childhealthrecord.entity.ChildProfileEntity;
import com.example.childhealthrecord.entity.VacStatus;
import com.example.childhealthrecord.entity.Vaccination;
import com.example.childhealthrecord.mapper.ChildProfileMapper;
import com.example.childhealthrecord.repository.ChildProfileRepository;
import com.example.childhealthrecord.repository.VaccinationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChildProfileService {

    private final ChildProfileRepository childProfileRepository;
    private final VaccinationRepository vaccinationRepository;

    public ChildProfileService(ChildProfileRepository childProfileRepository, VaccinationRepository vaccinationRepository) {
        this.childProfileRepository = childProfileRepository;
        this.vaccinationRepository = vaccinationRepository;
    }

    public List<ChildProfileEntity> findAll() {

        return childProfileRepository.findAll();
    }

    public void save(ChildProfileEntity childProfile) {
        childProfileRepository.save(childProfile);
    }

    public ChildProfileEntity findById(Integer id) {
        return childProfileRepository.findById(id).get();
    }

    public void deleteById(Integer id) {
        childProfileRepository.deleteById(id);
    }

    public void saveChildProfileDtoToEntity(ChildProfileDto childProfileDto){
        ChildProfileEntity entity = childProfileRepository.save(ChildProfileMapper.toEntity(childProfileDto));
        List<Vaccination> list = new ArrayList<>();
        list.add(new Vaccination("mandatory", "Hepatitis B","0", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "BCG","0", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "6in1","0", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "Pneumococci","0", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "Rotavirus","2", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("recommended", "Meningococci","2", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "6in1","4", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "Pneumococci","4", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "Rotavirus","4", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("recommended", "Meningococci","4", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "6in1","5 - 6", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "Rotavirus","5 - 6", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "Hepatitis B","7", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("recommended", "Meningococci","7", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "MMR","13 - 15", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "Pneumococci","13 - 15", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("recommended", "Meningococci","13 - 15", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("recommended", "Chickenpox","13 - 15", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("recommended", "KZM","13 - 15", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "6in1","16 - 18", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("recommended", "Chickenpox","13 - 15", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("recommended", "Hepatitis A","24", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("recommended", "Hepatitis A","30 - 36", VacStatus.TO_ARRANGE, "",  entity));

        vaccinationRepository.saveAll(list);
    }
}
