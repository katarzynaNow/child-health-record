package com.example.childhealthrecord.model;

import com.example.childhealthrecord.entity.Symptom;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

public class DiseaseModel {

    @Size(min=2, max=30)
    private String name;

    private String startingDate;

    private String endingDate;

    @Enumerated(EnumType.STRING)
    private Symptom symptom1;

    @Enumerated(EnumType.STRING)
    private Symptom symptom2;

    @Enumerated(EnumType.STRING)
    private Symptom symptom3;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }

    public Symptom getSymptom1() {
        return symptom1;
    }

    public void setSymptom1(Symptom symptom1) {
        this.symptom1 = symptom1;
    }

    public Symptom getSymptom2() {
        return symptom2;
    }

    public void setSymptom2(Symptom symptom2) {
        this.symptom2 = symptom2;
    }

    public Symptom getSymptom3() {
        return symptom3;
    }

    public void setSymptom3(Symptom symptom3) {
        this.symptom3 = symptom3;
    }
}
