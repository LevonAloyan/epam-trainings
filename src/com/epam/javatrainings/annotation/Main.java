package com.epam.javatrainings.annotation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("abc");
        customerDto.setEmail("userdomain.com");
        LocalDate localDate = LocalDate.parse("2010-10-02");
        customerDto.setDiscountRate(-7);

        customerDto.setBirthDay(localDate);

        Validator validator = new Validator();
        validator.validate(customerDto);

        ValidationErrors validationErrors = new ValidationErrors();
        System.out.println(validationErrors.validateErrorList(customerDto));


    }
}
