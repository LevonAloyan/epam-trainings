package com.epam.javatrainings.annotations.exceptions;

public class NotAdulthoodException extends Exception {
    public NotAdulthoodException() {
    }

    public NotAdulthoodException(String message) {
        System.out.println(message);
    }

    public NotAdulthoodException(String message, Throwable cause) {
        super(message, cause);
    }
}
