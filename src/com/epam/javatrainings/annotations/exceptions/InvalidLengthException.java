package com.epam.javatrainings.annotations.exceptions;

public class InvalidLengthException extends Exception {
    public InvalidLengthException() {
    }

    public InvalidLengthException(String message) {
        System.out.println(message);
    }

    public InvalidLengthException(String message, Throwable cause) {
        super(message, cause);
    }

}
