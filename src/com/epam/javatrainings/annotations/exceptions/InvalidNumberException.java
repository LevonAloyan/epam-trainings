package com.epam.javatrainings.annotations.exceptions;

public class InvalidNumberException extends Exception {
    public InvalidNumberException() {
    }

    public InvalidNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNumberException(String message) {
        System.out.println(message);
    }
}
