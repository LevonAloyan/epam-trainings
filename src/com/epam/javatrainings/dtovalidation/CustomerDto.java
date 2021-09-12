package com.epam.javatrainings.dtovalidation;

import com.epam.javatrainings.dtovalidation.annotation.*;

import java.time.LocalDate;

public final class CustomerDto {
  @Length(min = 2, max = 30)
  public final String name;

  @Length(min = 5, max = 15)
  @Email
  private final String email;

  @Adulthood private final LocalDate birthDay;

  @Min(0)
  @Max(100)
  private final int discountRate;

  public CustomerDto(String name, String email, String birthDay, int discountRate) {
    this.name = name;
    this.email = email;
    this.birthDay = LocalDate.parse(birthDay);
    this.discountRate = discountRate;
  }
}
