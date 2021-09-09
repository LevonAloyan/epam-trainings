package com.epam.javatrainings.annotations;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Shant");
        customerDto.setEmail("shant@mail.com");
        LocalDate localDate = LocalDate.parse("2000-12-30");
        customerDto.setBirthDay(localDate);
        customerDto.setDiscountRate(10);
        Validator validator=new Validator();
        validator.validate1(customerDto);
        validator.validate2(customerDto);
        validator.validate3(customerDto);
        try {
            validator.validate4(customerDto);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
