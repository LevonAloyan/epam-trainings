package com.epam.javatrainings.exceptions;

public class MyFileNotFoundException extends Exception {

    public MyFileNotFoundException() {
        super();
    }

    public MyFileNotFoundException(String message) {
        super(message);
    }

    public MyFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyFileNotFoundException(Throwable cause) {
        super(cause);
    }

    protected MyFileNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
