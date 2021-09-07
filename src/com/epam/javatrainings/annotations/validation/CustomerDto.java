package com.epam.javatrainings.annotations.validation;

import java.time.LocalDate;

public class CustomerDto {
    public CustomerDto(String name, String email, LocalDate birthDay, int discountRate) {
        this.name = name;
        this.email = email;
        this.birthDay = birthDay;
        this.discountRate = discountRate;
    }

    @Length(min = 2, max = 30)
    private String name;

    @Email
    private String email;

    @Adulthood
    private LocalDate birthDay;

    @Min(val = 0)
    @Max(val = 100)
    private int discountRate;
}
