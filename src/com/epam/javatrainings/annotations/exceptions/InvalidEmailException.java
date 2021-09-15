package com.epam.javatrainings.annotations.exceptions;

public class InvalidEmailException extends Exception {
    public InvalidEmailException() {
    }

    public InvalidEmailException(String message) {
        System.out.println(message);
    }

    public InvalidEmailException(String message, Throwable cause) {
        super(message, cause);
    }


}
