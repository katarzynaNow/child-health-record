package com.example.childhealthrecord.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "vaccinations")
@Getter
@Setter
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "child_id")
    private ChildProfileEntity child;

    public Vaccination(String scope, String name, String childrenAgeInMonths, VacStatus status, String notes, ChildProfileEntity child) {
        this.scope = scope;
        this.name = name;
        this.childrenAgeInMonths = childrenAgeInMonths;
        this.status = status;
        this.notes = notes;
        this.child = child;
    }
}
