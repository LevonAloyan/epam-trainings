package com.epam.javatrainings.annotation;

import com.epam.javatrainings.annotation.constants.Constants;
import com.epam.javatrainings.annotation.model.CustomerDto;
import com.epam.javatrainings.annotation.validator.Validator;
import java.time.LocalDate;
import java.time.Month;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    Map<String, String> error;
    CustomerDto c =
        new CustomerDto(
            Constants.VALID_NAME_FOR_TEST,
            Constants.VALID_EMAIL_FOR_TEST,
            LocalDate.of(Constants.VALID_ADULTHOOD_YEAR, Month.JANUARY, Constants.DAY_OF_MONTH),
            Constants.VALID_DISCOUNT_FOR_TEST);
    error = Validator.validate(c);
    // Print errors when user all field correct
    System.out.println(error.isEmpty());
    System.out.println();

    c.setName(Constants.INVALID_NAME_FOR_TEST);
    error = Validator.validate(c);
    // Print errors when user send only invalid name
    error.entrySet().forEach(System.out::println);
    System.out.println();

    c.setName(Constants.VALID_NAME_FOR_TEST);
    c.setDiscountRate(Constants.INVALID_DISCOUNT_FOR_TEST);
    error = Validator.validate(c);
    // Print errors when user send only invalid discountRate
    error.entrySet().forEach(System.out::println);
    System.out.println();

    c.setEmail(Constants.INVALID_EMAIL_FOR_TEST);
    c.setBirthDay(
        LocalDate.of(Constants.IN_ADULTHOOD_YEAR, Month.FEBRUARY, Constants.DAY_OF_MONTH));
    c.setName(Constants.INVALID_NAME_FOR_TEST);
    // Print errors when user send all field invalid
    error = Validator.validate(c);
    error.entrySet().forEach(System.out::println);
  }
}
