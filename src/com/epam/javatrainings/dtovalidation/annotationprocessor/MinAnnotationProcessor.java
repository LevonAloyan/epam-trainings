package com.epam.javatrainings.dtovalidation.annotationprocessor;

import com.epam.javatrainings.dtovalidation.annotation.Min;
import com.epam.javatrainings.dtovalidation.error.FieldError;

import java.util.Optional;
import java.lang.annotation.Annotation;

// Accepts int.
public class MinAnnotationProcessor {
  public static <T extends Annotation> Optional<FieldError> validate(Object val, String name, T a) {
    if (!(val instanceof Integer)) {
      throw new IllegalStateException("MIN annotation is placed on inappropriate datatype");
    }
    if ((Integer) val >= ((Min) a).value()) {
      return Optional.empty();
    }
    return Optional.of(
        new FieldError(name, name.toUpperCase() + " should be higher than " + ((Min) a).value()));
  }
}
