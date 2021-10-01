package com.epam.javatrainings.annotation;

import com.epam.javatrainings.annotation.adulthood.Adulthood;
import com.epam.javatrainings.annotation.email.Email;
import com.epam.javatrainings.annotation.length.Length;
import com.epam.javatrainings.annotation.max.Max;
import com.epam.javatrainings.annotation.min.Min;

import java.time.LocalDate;

public class CustomerDTO {
    public CustomerDTO(String name, String email, LocalDate birthDay, int discountRate) {
        this.name = name;
        this.email = email;
        this.birthDay = birthDay;
        this.discountRate = discountRate;
    }

    @Length(min = 5, max = 25)
    private String name;

    @Email
    private String email;

    @Adulthood
    private LocalDate birthDay;

    @Min(min = 5)
    @Max(max = 75)
    private int discountRate;

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

