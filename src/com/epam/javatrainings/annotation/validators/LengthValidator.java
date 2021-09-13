package com.epam.javatrainings.annotation.validators;

import com.epam.javatrainings.annotation.custom.Length;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LengthValidator implements ConstraintValidator<Length, String> {
  private int lower;
  private int upper;

  @Override
  public void initialize(Length constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
    this.lower = constraintAnnotation.min();
    this.upper = constraintAnnotation.max();
  }

  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    return s.length() >= lower && s.length() <= upper;
  }
}
