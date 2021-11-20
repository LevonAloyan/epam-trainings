package com.epam.javatrainings.annotations;

import java.time.LocalDate;

public class Dto {
    @Length(min=2,max=14)
    private String name;
    @Email
    private String email;
    @Adulthood
    private LocalDate birthday;
    @Min(0)
    @Max(100)
    private int discount;

    public Dto(String name, String email, LocalDate birthday, int discount) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.discount = discount;
    }
}
