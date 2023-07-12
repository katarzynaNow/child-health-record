package com.example.childhealthrecord.model;

import jakarta.persistence.*;

@Entity
@Table(name="Disease")
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private java.lang.String name;

    private int durationDays;

    private java.lang.String symptoms;

    public Disease() {
    }

    public Disease(Integer id, java.lang.String name, int durationDats, java.lang.String symptoms) {
        this.id = id;
        this.name = name;
        this.durationDays = durationDats;
        this.symptoms = symptoms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(int durationDats) {
        this.durationDays = durationDats;
    }

    public java.lang.String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(java.lang.String symptoms) {
        this.symptoms = symptoms;
    }

}
