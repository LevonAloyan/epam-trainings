package com.epam.javatrainings.annotation.custom;

import com.epam.javatrainings.annotation.validators.MinValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = MinValidator.class)
public @interface Min {
  int value() default 30;

  String message() default "Max should be 30";

  Class<?>[] groups() default {};
}
