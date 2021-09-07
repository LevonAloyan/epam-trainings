package com.epam.javatrainings.annotations;

import java.time.LocalDate;

public class CustomerDto {
    @Validator.Length(min=2,max=20)
    public String name;
    @Validator.Email
    public String email;
    @Validator.Adulthood
    public LocalDate birthday;
    @Validator.Min(0)
    @Validator.Max(100)
    public int discount;

    public CustomerDto(String n,String e,LocalDate b,int d)
    {
        name=n;
        email=e;
        birthday=b;
        discount=d;
    }

    public static void main(String[] args) {
        LocalDate d=LocalDate.now();
        LocalDate b=d.minusYears(14);
        System.out.println(b);
        CustomerDto dto=new CustomerDto("A","#aahahha@gmailcm",b,102);
        Validator v=new Validator();
        v.validate(dto);
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getDiscount() {
        return discount;
    }
}
