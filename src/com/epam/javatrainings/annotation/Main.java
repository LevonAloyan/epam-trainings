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
            Constants.NAME_FOR_TEST,
            Constants.EMAIL_FOR_TEST,
            LocalDate.of(Constants.YEAR_FOR_TEST, Month.JANUARY, Constants.DAY_OF_MONTH),
            Constants.DISCOUNT_FOR_TEST);
    error = Validator.validate(c);
    //Print errors
    error.entrySet().forEach(System.out::println);
  }
}
