package com.epam.javatrainings.dtovalidation.exception;

public class AnnotationProcessorFailedException extends RuntimeException {

  public AnnotationProcessorFailedException(String message, Throwable cause) {
    super(message, cause);
  }
}
