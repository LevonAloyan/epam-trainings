package com.epam.javatrainings.dtovalidation.annotationprocessor;

import com.epam.javatrainings.dtovalidation.error.FieldError;

import java.time.Period;
import java.util.Optional;
import java.time.LocalDate;
import java.lang.annotation.Annotation;

// Accepts string.
public final class AdulthoodAnnotationProcessor {
  public static <T extends Annotation> Optional<FieldError> validate(Object val, String name, T a) {
    if (!(val instanceof LocalDate)) {
      throw new IllegalStateException("ADULTHOOD annotation is placed on inappropriate datatype");
    }
    // check the client has reached the age of majority
    if (Period.between((LocalDate) val, LocalDate.now()).getYears() >= 18) {
      return Optional.empty();
    }
    return Optional.of(new FieldError(name, "You are still underage 😃"));
  }
}
