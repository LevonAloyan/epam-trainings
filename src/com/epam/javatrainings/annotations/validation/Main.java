package com.epam.javatrainings.annotations.validation;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        CustomerDto c = new CustomerDto("j", "john@mail.am",
                LocalDate.of(2004, Month.APRIL, 8), 1008);
        List<Error> errors = new ArrayList<>();

        try {
            errors = DtoValidationService.validate(c);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        for (Error error: errors) {
            System.out.println(error.getValidationErrorMessage());
        }

        System.out.println("");

        Set<String> authors = new HashSet<>();

        BookDto b = new BookDto(authors, "orelly@mail.com", 23, 555);
        errors = new ArrayList<>();

        try {
            errors = DtoValidationService.validate(b);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        for (Error error: errors) {
            System.out.println(error.getValidationErrorMessage());
        }
    }
}
