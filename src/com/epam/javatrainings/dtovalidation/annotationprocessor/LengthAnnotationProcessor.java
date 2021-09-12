package com.epam.javatrainings.dtovalidation.annotationprocessor;

import com.epam.javatrainings.dtovalidation.error.FieldError;
import com.epam.javatrainings.dtovalidation.annotation.Length;

import java.util.Map;
import java.util.Optional;
import java.util.Collection;
import java.lang.annotation.Annotation;

// Supported types are String, Collection, Map and arrays.
public final class LengthAnnotationProcessor {

  public static <T extends Annotation> Optional<FieldError> validate(Object val, String name, T a) {
    if (!isValidDataType(val)) {
      throw new IllegalStateException("LENGTH annotation is placed on inappropriate datatype");
    }
    int fieldLength = getFieldLength(val);
    // Check if the annotated element length is between min and max (inclusive).
    if (fieldLength >= ((Length) a).min() && fieldLength <= ((Length) a).max()) {
      return Optional.empty();
    }
    return Optional.of(new FieldError(name, "The LENGTH value is out-of-range!"));
  }

  private static boolean isValidDataType(Object o) {
    return o != null && o.getClass().isArray()
        || o instanceof String
        || o instanceof Collection
        || o instanceof Map;
  }

  private static int getFieldLength(Object o) {
    if (o instanceof String) {
      return ((String) o).length();
    }
    if (o.getClass().isArray()) {
      return ((Object[]) o).length;
    }
    if (o instanceof Collection) {
      return ((Collection<?>) o).size();
    }
    return ((Map<?, ?>) o).size();
  }
}
