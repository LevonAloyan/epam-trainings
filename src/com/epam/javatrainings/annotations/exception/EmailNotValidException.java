package com.epam.javatrainings.annotations.exception;

public class EmailNotValidException extends Exception{
    public EmailNotValidException() {
    }

    public EmailNotValidException(String message) {
        super(message);
    }

    public EmailNotValidException(String message, Throwable cause) {
        super(message, cause);
    }
}
