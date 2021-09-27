package com.epam.javatrainings.annotations.exception;

public class InappropriateAgeException extends Exception{
    public InappropriateAgeException() {
    }

    public InappropriateAgeException(String message) {
        super(message);
    }

    public InappropriateAgeException(String message, Throwable cause) {
        super(message, cause);
    }
}
