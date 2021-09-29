package com.epam.javatrainings.annotations.processor;

import com.epam.javatrainings.annotations.exception.InappropriateAgeException;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class AdulthoodAnnotationProcessor {
    public <T> AdulthoodAnnotationProcessor(Field field, T t) throws InappropriateAgeException, IllegalAccessException {

        field.setAccessible(true);
        LocalDate localDate = (LocalDate) field.get(t);
        int birthYear = localDate.getYear();
        int currentYear = LocalDate.now().getYear();
        if (currentYear - birthYear < 18) {
            throw new InappropriateAgeException("Your age is Inappropriate , : please try few years later :)");
        }
    }
}
