package com.epam.javatrainings.annotation.custom;

import com.epam.javatrainings.annotation.validators.LengthValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = LengthValidator.class)
public @interface Length {

  int min() default 2;

  int max() default 30;

  String message() default "Length should be between 2-30";
}
