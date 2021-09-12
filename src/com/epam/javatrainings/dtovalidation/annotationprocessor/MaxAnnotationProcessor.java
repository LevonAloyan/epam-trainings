package com.epam.javatrainings.dtovalidation.annotationprocessor;

import com.epam.javatrainings.dtovalidation.annotation.Max;
import com.epam.javatrainings.dtovalidation.error.FieldError;

import java.util.Optional;
import java.lang.annotation.Annotation;

// Accepts int.
public final class MaxAnnotationProcessor {
  public static <T extends Annotation> Optional<FieldError> validate(Object val, String name, T a) {
    if (!(val instanceof Integer)) {
      throw new IllegalStateException("MAX annotation is placed on inappropriate datatype");
    }
    if ((Integer) val <= ((Max) a).value()) {
      return Optional.empty();
    }
    return Optional.of(new FieldError(name, ((Max) a).message()));
  }
}
