package com.example.childhealthrecord.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name="children_profiles")
@Getter
@Setter
public class ChildProfileEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    private String birthDate;

    @Lob
    @Column(name = "picture")
    private byte[] picture;

    @ManyToOne
    @JoinColumn
    private DiseaseEntity disease;

    @ManyToOne
    @JoinColumn
    private AppointmentEntity appointment;

    @ManyToOne
    @JoinColumn
    private Vaccination vaccination;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;
}
