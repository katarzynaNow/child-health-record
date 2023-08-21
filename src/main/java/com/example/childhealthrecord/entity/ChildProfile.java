package com.example.childhealthrecord.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name="child_profile")
@Getter
@Setter
public class ChildProfile {

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

    @OneToMany
    @Column(name = "diseases")
    private List<DiseaseEntity> diseases;

    @OneToMany
    @Column(name = "appointments")
    private List<AppointmentEntity> appointments;

    @OneToMany
    @Column(name = "vaccinations")
    private List<Vaccination> vaccinations;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;
}
