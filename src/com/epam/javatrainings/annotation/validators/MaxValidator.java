package com.epam.javatrainings.annotation.validators;

import com.epam.javatrainings.annotation.custom.Max;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MaxValidator implements ConstraintValidator<Max, Integer> {
  private int max;
  private String value;

  @Override
  public void initialize(Max constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
    this.max = constraintAnnotation.value();
    this.value = constraintAnnotation.message();
  }

  @Override
  public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
    return (integer < max);
  }
}
