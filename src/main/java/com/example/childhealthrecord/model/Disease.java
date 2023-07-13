package com.example.childhealthrecord.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Instant startingDate;
    private Instant endingDate;

    private Symptom symptom;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    public Disease() {
    }

    public Disease(String name, Instant startingDate, Instant endingDate, Symptom symptoms) {
        this.name = name;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.symptom = symptoms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Symptom getSymptom() {
        return symptom;
    }

    public void setSymptom(Symptom symptoms) {
        this.symptom = symptoms;
    }

    public Instant getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Instant startingDate) {
        this.startingDate = startingDate;
    }

    public Instant getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Instant endingDate) {
        this.endingDate = endingDate;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
