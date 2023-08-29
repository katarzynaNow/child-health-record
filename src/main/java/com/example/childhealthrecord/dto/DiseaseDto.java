package com.example.childhealthrecord.dto;

import com.example.childhealthrecord.entity.Symptom;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiseaseDto {

    @Size(min=2, max=30)
    private String name;

    @Size(min = 10, max = 10)
    private String startingDate;

    @Size(min = 10, max = 10)
    private String endingDate;

    private Symptom symptom1;

    private Symptom symptom2;

    private Symptom symptom3;
}
