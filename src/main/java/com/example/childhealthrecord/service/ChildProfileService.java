package com.example.childhealthrecord.service;

import com.example.childhealthrecord.dto.ChildProfileDto;
import com.example.childhealthrecord.dto.DiseaseDto;
import com.example.childhealthrecord.entity.ChildProfileEntity;
import com.example.childhealthrecord.entity.DiseaseEntity;
import com.example.childhealthrecord.mapper.ChildProfileMapper;
import com.example.childhealthrecord.mapper.DiseaseMapper;
import com.example.childhealthrecord.repository.ChildProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildProfileService {

    private final ChildProfileRepository childProfileRepository;

    public ChildProfileService(ChildProfileRepository childProfileRepository) {
        this.childProfileRepository = childProfileRepository;
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
        ChildProfileEntity childProfileEntity = ChildProfileMapper.toEntity(childProfileDto);

        childProfileRepository.save(childProfileEntity);
    }
}
