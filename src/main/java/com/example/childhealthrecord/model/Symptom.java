package com.example.childhealthrecord.model;

public enum Symptom {
    FEVER("fever"),
    COUGH("cough"),
    SORE_THROAT("sore throat"),
    CHILLS("chills"),
    RASH("rash"),
    RUNNY_NOSE("runny nose"),
    DIARRHEA("diarrhea"),
    VOMITING("vomiting");

    String name;

    Symptom(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
