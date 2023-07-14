package com.example.childhealthrecord.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Instant date;

    private String diagnosis;

    private String medicines;

    private Antibiotic antibiotic;

    private String notes;

   //@ManyToOne
    //@JoinColumn
    //private Disease disease;


    public Appointment() {
    }

    public Appointment(Instant date, String diagnosis, String medicines, Antibiotic antibiotic, String notes) {
        this.date = date;
        this.diagnosis = diagnosis;
        this.medicines = medicines;
        this.antibiotic = antibiotic;
        this.notes = notes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
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

   /* public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }*/
}