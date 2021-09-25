package com.epam.javatrainings.annotation;

import com.epam.javatrainings.annotation.validators.Validator;

import java.time.LocalDate;

public class MainTest {
  public static void main(String[] args) throws NoSuchMethodException {
    // Validation within constructor
    CustomerDto customerDto =
        new CustomerDto("Arsen", "yeritsyan.arsen@gmail.com", LocalDate.of(1990, 5, 14), 222);
  }
}
