package com.epam.javatrainings.annotation.custom;

import com.epam.javatrainings.annotation.validators.AdulthoodValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = AdulthoodValidator.class)
public @interface Adulthood {
  int age = 18;

  String message() default "You should be 18+";

  Class<?>[] groups() default {};
}
