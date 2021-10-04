package com.epam.javatrainings.validation;

import com.epam.javatrainings.validation.dto.CustomerDto;
import com.epam.javatrainings.validation.service.ValidatorService;
import com.epam.javatrainings.validation.service.error.Error;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("J");
        customerDto.setEmail("john@@gmail.com");
        customerDto.setBirthDay(LocalDate.of(2010, 12, 6));
        customerDto.setDiscountRate(150);

        ValidatorService validatorService = ValidatorService.getInstance();
        List<Error> errors = List.of();

        try {
            errors = validatorService.validate(customerDto);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        errors.forEach(System.out::println);
    }
}
