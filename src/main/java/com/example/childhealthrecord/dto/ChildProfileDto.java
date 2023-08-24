package com.example.childhealthrecord.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChildProfileDto {

    @Size(min=2, max=30)
    private String name;

    @Size(min = 10, max = 10)
    private String birthDate;

    private byte[] picture;

}
