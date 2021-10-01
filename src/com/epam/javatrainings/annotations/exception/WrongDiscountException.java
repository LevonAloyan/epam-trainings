package com.epam.javatrainings.annotations.exception;

public class WrongDiscountException extends Exception{
    public WrongDiscountException() {
    }

    public WrongDiscountException(String message) {
        super(message);
    }

    public WrongDiscountException(String message, Throwable cause) {
        super(message, cause);
    }
}
