package com.epam.javatrainings.annootation_based_DTO.exception;

public class CustomerNameLengthException extends RuntimeException {
    public CustomerNameLengthException(String message) {
        super(message);
    }
}
