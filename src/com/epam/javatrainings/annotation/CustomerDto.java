package com.epam.javatrainings.annotation;

import java.time.LocalDate;

public class CustomerDto {

    @Length(min = 4, max = 20)
    private String name;

    @Email
    private String email;

    @Adulthood
    private LocalDate birthDay;

    @Min(0)
    @Max(100)
    private int discountRate;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
