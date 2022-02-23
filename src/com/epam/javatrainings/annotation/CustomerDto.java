package com.epam.javatrainings.annotation;

import com.epam.javatrainings.annotation.custom.*;
import com.epam.javatrainings.annotation.validators.Validator;

import java.time.LocalDate;

public class CustomerDto {

  @Length(min = 15, max = 20)
  private String name;

  @Email private String email;

  @Adulthood private LocalDate birthDay;

  @Min(value = 0)
  @Max(value = 100)
  private int discountRate;

  public CustomerDto(String name, String email, LocalDate birthDay, int discountRate)
      throws NoSuchMethodException {

    this.name = name;
    this.email = email;
    this.birthDay = birthDay;
    this.discountRate = discountRate;
    Validator.validate(this);
  }
}
