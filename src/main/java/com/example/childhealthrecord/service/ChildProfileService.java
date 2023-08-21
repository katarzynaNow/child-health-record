package com.example.childhealthrecord.service;

import com.example.childhealthrecord.entity.ChildProfile;
import com.example.childhealthrecord.entity.DiseaseEntity;
import com.example.childhealthrecord.repository.ChildProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChildProfileService {

    private final ChildProfileRepository childProfileRepository;

    public ChildProfileService(ChildProfileRepository childProfileRepository) {
        this.childProfileRepository = childProfileRepository;
    }

    public List<ChildProfile> findAll() {

        return childProfileRepository.findAll();
    }

    public void save(ChildProfile childProfile) {
        childProfileRepository.save(childProfile);
    }

    public ChildProfile findById(Integer id) {
        return childProfileRepository.findById(id).get();
    }

    public void deleteById(Integer id) {
        childProfileRepository.deleteById(id);
    }
}
