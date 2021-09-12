package com.epam.javatrainings.dtovalidation.error;

import java.util.List;
import java.util.ArrayList;

public class FieldError {
  private final String fieldName;
  private final String message;
  private final List<String> messages = new ArrayList<>();

  public FieldError(String fieldName, String message) {
    this.fieldName = fieldName;
    this.message = message;
    this.messages.add(message);
  }

  public FieldError(FieldError f) {
    this(f.fieldName, f.message);
  }

  public String getFieldName() {
    return fieldName;
  }

  public String getMessage() {
    return message;
  }

  public void addMessage(String message) {
    messages.add(message);
  }

  @Override
  public String toString() {
    return "\n\t\tFieldError{"
        + " fieldName='"
        + fieldName
        + '\''
        + ", messages="
        + messages
        + ' '
        + '}';
  }
}
