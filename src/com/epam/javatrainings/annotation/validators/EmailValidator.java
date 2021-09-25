package com.epam.javatrainings.annotation.validators;

import com.epam.javatrainings.annotation.custom.Email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<Email, String> {
  String regexString;

  @Override
  public void initialize(Email constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
    this.regexString = constraintAnnotation.regex();
  }

  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    Pattern pattern = Pattern.compile(this.regexString);
    Matcher matcher = pattern.matcher(s);
    return matcher.matches();
  }
}
