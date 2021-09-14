package com.epam.javatrainings.annootation_based_DTO.exception;

public class CustomerAgeException extends RuntimeException {
    public CustomerAgeException(String massage) {
        super(massage);
    }
}
