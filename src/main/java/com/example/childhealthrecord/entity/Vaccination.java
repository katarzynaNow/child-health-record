package com.example.childhealthrecord.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vaccinations")
public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String scope;

    private String name;

    private String childrenAgeInMonths;

    @Enumerated(EnumType.STRING)
    private VacStatus status;

    private String notes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChildrenAgeInMonths() {
        return childrenAgeInMonths;
    }

    public void setChildrenAgeInMonths(String childrenAge) {
        this.childrenAgeInMonths = childrenAge;
    }

    public VacStatus getStatus() {
        return status;
    }

    public void setStatus(VacStatus status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
