package com.example.childhealthrecord.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vaccinations")
public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "scope")
    private String scope;

    @Column(name = "name")
    private String name;

    @Column(name = "childrenAgeInMonths")
    private String childrenAgeInMonths;

    @Column(name = "status")
    private String status;

    @Column(name = "notes")
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
