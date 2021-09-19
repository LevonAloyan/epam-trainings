package com.epam.javatrainings.threads.timer.exceptions;

public class InvalidMinuteException extends RuntimeException {
    public InvalidMinuteException() {
    }

    public InvalidMinuteException(String message) {
        System.out.println(message);
    }

    public InvalidMinuteException(String message, Throwable cause) {
        super(message, cause);
    }
}
