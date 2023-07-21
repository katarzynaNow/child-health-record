package com.example.childhealthrecord.model;

import com.example.childhealthrecord.entity.Antibiotic;
import com.example.childhealthrecord.entity.DiseaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

public class AppointmentModel {

    private String date;

    @Size(min=2, max=30)
    private String diagnosis;

    @Size(min=2, max=30)
    private String medicines;

    private Antibiotic antibiotic;

    @Size(max=200)
    private String notes;

    @ManyToOne
    @JoinColumn
    private DiseaseEntity disease;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public Antibiotic getAntibiotic() {
        return antibiotic;
    }

    public void setAntibiotic(Antibiotic antibiotic) {
        this.antibiotic = antibiotic;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public DiseaseEntity getDisease() {
        return disease;
    }

    public void setDisease(DiseaseEntity disease) {
        this.disease = disease;
    }
}
