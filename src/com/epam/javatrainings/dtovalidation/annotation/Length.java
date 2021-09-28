package com.epam.javatrainings.dtovalidation.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Validation
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Length {
  int min();

  int max();

  String message() default "The LENGTH value is out-of-range!";
}
