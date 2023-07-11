package com.example.childhealthrecord.model;

import jakarta.persistence.*;

@Entity
@Table(name="Disease")
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private int durationDats;

    private Symptoms symptoms;

    public Disease() {
    }

    public Disease(Integer id, String name, int durationDats, Symptoms symptoms) {
        this.id = id;
        this.name = name;
        this.durationDats = durationDats;
        this.symptoms = symptoms;
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

    public int getDurationDats() {
        return durationDats;
    }

    public void setDurationDats(int durationDats) {
        this.durationDats = durationDats;
    }

    public Symptoms getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Symptoms symptoms) {
        this.symptoms = symptoms;
    }
}
