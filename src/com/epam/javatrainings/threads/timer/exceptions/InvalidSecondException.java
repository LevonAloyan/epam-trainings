package com.epam.javatrainings.threads.timer.exceptions;

public class InvalidSecondException extends RuntimeException {
    public InvalidSecondException() {
    }

    public InvalidSecondException(String message) {
        System.out.println(message);
    }

    public InvalidSecondException(String message, Throwable cause) {
        super(message, cause);
    }
}
