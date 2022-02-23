package com.epam.javatrainings.annotation.custom;

import com.epam.javatrainings.annotation.validators.EmailValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = EmailValidator.class)
public @interface Email {
  String regex() default
      "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+(?:.[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

  String message() default "Email must have @[a-zA-Z0-9-]....";

  Class<?>[] groups() default {};
}
