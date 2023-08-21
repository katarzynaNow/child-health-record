package com.example.childhealthrecord.repository;

import com.example.childhealthrecord.entity.ChildProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildProfileRepository extends JpaRepository<ChildProfile, Integer> {
}
