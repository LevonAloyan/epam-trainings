package com.epam.javatrainings.dtovalidation.error;

import java.util.List;
import java.util.ArrayList;

public final class ValidationError {
  private static final int STATUS_CODE = 400;
  private static final String MESSAGE = "Validation error";
  private int errorCount = 0;
  private final List<FieldError> errors;

  public ValidationError() {
    this.errors = new ArrayList<>();
  }

  public int getErrorCount() {
    return errorCount;
  }

  public void addFieldError(FieldError fieldError) {
    errorCount++;
    FieldError found =
        errors.stream()
            .filter(e -> e.getFieldName().equals(fieldError.getFieldName()))
            .findFirst()
            .orElse(null);

    if (found == null) {
      errors.add(fieldError);
    } else {
      found.addMessage(fieldError);
    }
  }

  @Override
  public String toString() {
    return "ValidationError{"
        + "\n\tstatusCode="
        + STATUS_CODE
        + ",\n\tmessage='"
        + MESSAGE
        + '\''
        + ",\n\terrorCount="
        + errorCount
        + ",\n\terrors="
        + errors
        + '\n'
        + '}';
  }
}
