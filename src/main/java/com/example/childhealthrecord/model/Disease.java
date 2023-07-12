package com.example.childhealthrecord.model;

import jakarta.persistence.*;

@Entity
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String startingDate;
    private String endingDate;

    private String symptoms;

    public Disease() {
    }

    public Disease(String name, String startingDate, String endingDate, String symptoms) {
        this.name = name;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
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


    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
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
}
