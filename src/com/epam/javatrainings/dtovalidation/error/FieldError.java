package com.epam.javatrainings.dtovalidation.error;

import java.util.List;
import java.util.ArrayList;

public final class FieldError {
  private final String fieldName;
  private final List<String> messages = new ArrayList<>();

  public FieldError(String fieldName, String message) {
    this.fieldName = fieldName;
    this.messages.add(message);
  }

  public String getFieldName() {
    return fieldName;
  }

  public void addMessage(FieldError fieldError) {
    messages.addAll(fieldError.messages);
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
