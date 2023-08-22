package com.example.childhealthrecord.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name="diseases")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiseaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="starting_date")
    private String startingDate;

    @Column(name="ending_date")
    private String endingDate;

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

    @OneToMany
    private List<ChildProfileEntity> childProfile;

    @UpdateTimestamp
    @Column(name="updated_at")
    private Instant updatedAt;

    @OneToMany(mappedBy = "disease", cascade = CascadeType.ALL)
    @Column(name="appointments")
    private List<AppointmentEntity> appointments;

}
