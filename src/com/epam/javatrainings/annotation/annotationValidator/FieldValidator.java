package com.epam.javatrainings.annotation.annotationValidator;

/**
 * Created by Hayk on 11.09.2021.
 */
public interface FieldValidator <T>{
    void check(T obj);
}
