package com.epam.javatrainings.annotation;

import com.epam.javatrainings.annotation.anotations.*;

import java.time.LocalDate;

public class Customer {

    @Length(min = 2, max = 10)
    private String name ;
    @Email
    private String email;
    @Adulthood
    private LocalDate birthday;
    @Min(0)
    @Max(100)
    private int discountRate;
    @Length(min = 2,max = 6)
    private String nickname;


    public Customer(String name, String email, LocalDate birthday, int discountRate, String nickname) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.discountRate = discountRate;
        this.nickname = nickname;
    }
}
