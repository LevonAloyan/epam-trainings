package com.epam.javatrainings.annotation.validators;

import com.epam.javatrainings.annotation.custom.Min;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinValidator implements ConstraintValidator<Min, Integer> {
  private int min;

  @Override
  public void initialize(Min constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
    this.min = constraintAnnotation.value();
  }

  @Override
  public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
    return integer > min;
  }
}
