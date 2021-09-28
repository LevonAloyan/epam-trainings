package com.epam.javatrainings.dtovalidation.annotationprocessor;

import com.epam.javatrainings.dtovalidation.error.FieldError;
import com.epam.javatrainings.dtovalidation.annotation.Email;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.annotation.Annotation;

// Accepts string.
public final class EmailAnnotationProcessor {
  // RFC 5322 Official Standard
  private static final String EMAIL_REGEX =
      "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21"
          + "\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])"
          + "?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2"
          + "[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-"
          + "\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
  private static final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);

  public static <T extends Annotation> Optional<FieldError> validate(Object val, String name, T a) {
    if (!(val instanceof String)) {
      throw new IllegalStateException("EMAIL annotation is placed on inappropriate datatype");
    }
    Matcher m = emailPattern.matcher((String) val);
    if (m.matches()) {
      return Optional.empty();
    }
    return Optional.of(new FieldError(name, ((Email) a).message()));
  }
}
