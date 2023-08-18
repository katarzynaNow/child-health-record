package com.example.childhealthrecord.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vaccinations")
@Getter
@Setter
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

}
