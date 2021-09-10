package com.epam.javatrainings.pizza.dto;

import com.epam.javatrainings.pizza.annotations.*;

import java.time.LocalDate;

public class CustomerDto implements Dto{

    public CustomerDto(String name, String mail, LocalDate birthDate, int discountRate) {
        this.name = name;
        this.email = mail;
        this.birthDate = birthDate;
        this.discountRate = discountRate;
    }

    @Length(min = 8, max = 50)
    private String name;

    @Email
    private String email;

    @Adulthood
    private LocalDate birthDate;

    @Min(5)
    @Max(50)
    private int discountRate;


}
