package com.example.childhealthrecord.dto;

import com.example.childhealthrecord.entity.DiseaseEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentDto {

    @Size(min = 10, max = 10)
    private String date;

    @Size(min=2, max=30)
    private String diagnosis;

    @Size(min=2, max=30)
    private String medicines;


    private boolean antibiotic;

    @Size(max=200)
    private String notes;

    @NotNull
    private DiseaseEntity disease;

}
