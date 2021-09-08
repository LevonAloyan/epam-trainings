package com.epam.javatrainings.annotation;

import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {
        Customer customer = new Customer
                ("aaaaaxxxxxxxxxx","sargis@gmail.com",
                        LocalDate.of(2013,9,14),101);
        DTOValidator validator = new DTOValidatorImpl();
        validator.validate(customer);
    }
}
