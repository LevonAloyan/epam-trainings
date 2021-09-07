package com.epam.javatrainings.annotations.validation;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerDto c = new CustomerDto("j", "john@mail.am",
                LocalDate.of(2004, Month.APRIL, 8), 1008);
        List<String> errors = new ArrayList<>();

        try {
            errors = DtoValidationService.validate(c);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        for (String error: errors) {
            System.out.println(error);
        }
    }
}
