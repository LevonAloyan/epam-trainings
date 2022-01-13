package com.epam.javatrainings.annotation;

public interface DTOValidator {

    <T> void validate(T t);
}
