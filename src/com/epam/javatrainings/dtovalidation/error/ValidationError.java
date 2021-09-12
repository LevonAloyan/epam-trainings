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

  public void addFieldError(FieldError f) {
    errorCount++;
    FieldError fieldError =
        errors.stream()
            .filter(e -> e.getFieldName().equals(f.getFieldName()))
            .findFirst()
            .orElse(null);
    if (fieldError == null) {
      errors.add(new FieldError(f));
      return;
    }
    fieldError.addMessage(f.getMessage());
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
