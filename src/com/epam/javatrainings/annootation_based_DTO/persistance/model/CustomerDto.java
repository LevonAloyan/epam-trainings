package com.epam.javatrainings.annootation_based_DTO.persistance.model;

import com.epam.javatrainings.annootation_based_DTO.persistance.annotation.*;

import java.time.LocalDate;

public class CustomerDto {
    @Length(min = 2, max = 30)
    private String name;

    @Email
    private String email;

    @Adulthood
    private LocalDate birthDay;

    @Min(0)
    @Max(100)
    private int discountRate;

    public CustomerDto(String name, String email, LocalDate birthDay, int discountRate) {
        this.name = name;
        this.email = email;
        this.birthDay = birthDay;
        this.discountRate = discountRate;
    }

    public CustomerDto() {
    }
}
