package com.example.childhealthrecord.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name="diseases")
public class DiseaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="starting_date")
    private Instant startingDate;

    @Column(name="ending_date")
    private Instant endingDate;

    @Enumerated(EnumType.STRING)
    @Column(name="symptom_1")
    private Symptom symptom1;

    @Enumerated(EnumType.STRING)
    @Column(name="symptom_2")
    private Symptom symptom2;

    @Enumerated(EnumType.STRING)
    @Column(name="symptom_3")
    private Symptom symptom3;

    @CreationTimestamp
    @Column(name="created_at")
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private Instant updatedAt;

    @OneToMany(mappedBy = "disease")
    @Column(name="appointments")
    private List<Appointment> appointments;

    public DiseaseEntity() {
    }

    public DiseaseEntity(String name, Instant startingDate, Instant endingDate, Symptom symptom1,
                         Symptom symptom2, Symptom symptom3) {
        this.name = name;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.symptom1 = symptom1;
        this.symptom2 = symptom2;
        this.symptom3 = symptom3;
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

    public Symptom getSymptom1() {
        return symptom1;
    }

    public void setSymptom1(Symptom symptom1) {
        this.symptom1 = symptom1;
    }

    public Symptom getSymptom2() {
        return symptom2;
    }

    public void setSymptom2(Symptom symptom2) {
        this.symptom2 = symptom2;
    }

    public Symptom getSymptom3() {
        return symptom3;
    }

    public void setSymptom3(Symptom symptom3) {
        this.symptom3 = symptom3;
    }

    public Instant getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Instant startingDate) {
        this.startingDate = startingDate;
    }

    public Instant getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Instant endingDate) {
        this.endingDate = endingDate;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Disease{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                ", symptom1=" + symptom1 +
                ", symptom2=" + symptom2 +
                ", symptom3=" + symptom3 +
                '}';
    }
}
