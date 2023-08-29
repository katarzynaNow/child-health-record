package com.example.childhealthrecord.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vaccinations")
@Getter
@Setter
@NoArgsConstructor
public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="scope")
    private String scope;

    @Column(name="name")
    private String name;

    private String childrenAgeInMonths;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private VacStatus status;

    @Column(name="notes")
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
