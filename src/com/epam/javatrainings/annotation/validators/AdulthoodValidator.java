package com.epam.javatrainings.annotation.validators;

import com.epam.javatrainings.annotation.custom.Adulthood;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AdulthoodValidator implements ConstraintValidator<Adulthood, LocalDate> {
  private int age;

  @Override
  public void initialize(Adulthood constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
    this.age = constraintAnnotation.age;
  }

  @Override
  public boolean isValid(
      LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
    return null != localDate && localDate.isBefore(LocalDate.ofYearDay(age, 365));
  }
}
