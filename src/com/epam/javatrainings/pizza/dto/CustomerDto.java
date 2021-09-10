package com.epam.javatrainings.pizza.dto;

import com.epam.javatrainings.pizza.annotations.*;

import java.time.LocalDate;

public class CustomerDto implements Dto{

    public CustomerDto(String name, String mail, LocalDate birthDate, int discountRate) {
        this.name = name;
        this.mail = mail;
        this.birthDate = birthDate;
        this.discountRate = discountRate;
    }

    @Length(min = 8, max = 50)
    private String name;

    @Email
    private String mail;

    @Adulthood
    private LocalDate birthDate;

    @Min
    @Max
    private int discountRate;


}
