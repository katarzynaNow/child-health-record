package com.example.childhealthrecord.entity;

public enum Symptom {
    CHILLS ("chills"),
    COUGH ("cough"),
    DIARRHEA ("diarrhea"),
    FEVER ("fever"),
    RASH ("rash"),
    RUNNY_NOSE ("runny nose"),
    SORE_THROAT ("sore throat"),
    VOMITING ("vomiting");

    private String name;

    Symptom(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
