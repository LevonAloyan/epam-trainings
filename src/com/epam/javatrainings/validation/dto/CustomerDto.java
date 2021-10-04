package com.epam.javatrainings.validation.dto;

import com.epam.javatrainings.validation.annotations.*;

import java.time.LocalDate;

public class CustomerDto {

    @Length(min = 2, max = 30)
    private String name;

    @Email
    @Adulthood
    private String email;

    @Adulthood
    private LocalDate birthDay;

    @Min(0)
    @Max(100)
    private int discountRate;

    public CustomerDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }
}
