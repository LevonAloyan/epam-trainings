package com.epam.javatrainings;

import java.time.LocalDate;

public class CustomerDto {
    @Length(min = 2, max = 30)
    private String name;

    @Email
    private String email;

    @Adulthood
    private LocalDate birthDate;

    @Min(0)
    @Max(100)
    private int discountRate;

    public  CustomerDto(){}

    public  CustomerDto(String name, String email, LocalDate birthDate, int discountRate){
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.discountRate = discountRate;
    }


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public LocalDate getBirthDate(){
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }

    public int getDiscountRate(){
        return discountRate;
    }

    public void setDiscountRate(int discountRate){
        this.discountRate = discountRate;
    }
}
