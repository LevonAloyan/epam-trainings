package com.epam.javatrainings.annotations;

import com.epam.javatrainings.annotations.dto.CustomerDto;
import com.epam.javatrainings.annotations.validator.Validator;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        //test custom annotations
        CustomerDto customer = new CustomerDto();
        customer.setDiscountRate(1000);
        customer.setName("s");
        customer.setEmail("sjdh.hdh@sds.");
        customer.setBirthday(LocalDate.now());
        Validator validator = new Validator();
        validator.validate(customer);
    }
}
