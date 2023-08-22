package com.example.childhealthrecord.repository;

import com.example.childhealthrecord.entity.ChildProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildProfileRepository extends JpaRepository<ChildProfileEntity, Integer> {
}
