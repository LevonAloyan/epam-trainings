package com.epam.javatrainings.annotation;

import java.time.LocalDate;


public class Test{


    public static void main(String[] args) {
        Customer customer = new Customer
                ("a","sargis@gmail.com",
                        LocalDate.of(1955,9,14),1, "abi1232");
        DTOValidator validator = new DTOValidatorImpl();
        validator.validate(customer);
    }
}
