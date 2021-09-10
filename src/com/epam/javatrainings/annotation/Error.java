package com.epam.javatrainings.annotation;

public class Error {

    private String fieldName;
    private String errorMessage;

    public Error(String fieldName, String errorMessage) {
        this.fieldName = fieldName;
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return fieldName + ": " + errorMessage;
    }
}
