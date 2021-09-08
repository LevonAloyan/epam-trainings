package com.epam.javatrainings.annotation;

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

    public Customer(String name, String email, LocalDate birthday, int discountRate) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.discountRate = discountRate;
    }
}
