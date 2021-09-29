package com.epam.javatrainings.annotations.exception;

public class InappropriateNameException extends Exception{
    public InappropriateNameException() {
    }

    public InappropriateNameException(String message) {
        super(message);
    }

    public InappropriateNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
