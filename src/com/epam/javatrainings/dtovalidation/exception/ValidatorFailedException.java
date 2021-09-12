package com.epam.javatrainings.dtovalidation.exception;

public class ValidatorFailedException extends RuntimeException {
  public ValidatorFailedException(String message, Throwable cause) {
    super(message, cause);
  }
}
