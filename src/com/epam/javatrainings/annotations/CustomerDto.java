package com.epam.javatrainings.annotations;

import com.epam.javatrainings.annotations.annotation.*;

import java.time.LocalDate;

public class CustomerDto {

    @Length(min = 2, max = 30)
    private String name;

    @Email
    private String email;

    @Adulthood
    private LocalDate birthDate;

    @Min(min = 20)
    @Max // let take default value
    private int discountRate;


    public CustomerDto(String name, String email, LocalDate localDate, int discountRate) {
        this.name = name;
        this.email = email;
        this.birthDate = localDate;
        this.discountRate = discountRate;
    }

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

    public LocalDate getLocalDate() {
        return birthDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.birthDate = localDate;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }
}
