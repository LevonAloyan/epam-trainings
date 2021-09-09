package com.epam.javatrainings.annotations.dto;

import com.epam.javatrainings.annotations.custom_annotations.*;
import java.time.LocalDate;


public class CustomerDto {

    @Length(min = 2, max = 30)
    private String name;

    @Email
    private String email;

    @Adulthood
    private LocalDate birthday;

    @Min(min = 0)
    @Max(max = 100)
    private int discountRate;

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setBirthday(LocalDate birthday){
        this.birthday = birthday;
    }

    public void setDiscountRate(int discountRate){
        this.discountRate = discountRate;
    }

}
