package com.epam.javatrainings.annotation.model;

import com.epam.javatrainings.annotation.custom_annotations.*;

import java.time.LocalDate;

public class CustomerDto {
  @Length(min = 2, max = 30)
  private String name;

  @Email private final String email;
  @Adulthood private final LocalDate birthDay;

  @Min(0)
  @Max(100)
  private final int discountRate;

  public CustomerDto(String name, String email, LocalDate birthDay, int discountRate) {
    this.name = name;
    this.email = email;
    this.birthDay = birthDay;
    this.discountRate = discountRate;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public LocalDate getBirthDay() {
    return birthDay;
  }

  public int getDiscountRate() {
    return discountRate;
  }
}
