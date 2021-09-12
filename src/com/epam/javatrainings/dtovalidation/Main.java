package com.epam.javatrainings.dtovalidation;

import com.epam.javatrainings.dtovalidation.error.ValidationError;

import java.util.Optional;

public class Main {
  public static void main(String[] args) {
    Validator validator = new Validator();
    CustomerDto validDto = new CustomerDto("Jay", "jay@gmail.com", "2000-01-11", 51);
    CustomerDto invalidDto = new CustomerDto("J", "qwerty@mailcommon", "2004-01-11", -1);

    printValidationResult(validator.validate(validDto));
    printValidationResult(validator.validate(invalidDto));
  }

  private static void printValidationResult(Optional<ValidationError> v) {
    if (v.isEmpty()) {
      System.out.println("\nVALIDATION PASSED SUCCESSFULLY !\n");
    } else {
      System.out.println(v.get());
    }
  }
}
