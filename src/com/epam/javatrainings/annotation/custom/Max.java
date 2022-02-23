package com.epam.javatrainings.annotation.custom;

import com.epam.javatrainings.annotation.validators.MaxValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = MaxValidator.class)
public @interface Max {

  int value() default 30;

  String message() default "Max should be 30";

  Class<?>[] groups() default {};
}
