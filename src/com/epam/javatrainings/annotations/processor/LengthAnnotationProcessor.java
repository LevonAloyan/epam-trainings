package com.epam.javatrainings.annotations.processor;

import com.epam.javatrainings.annotations.annotation.Length;
import com.epam.javatrainings.annotations.exception.InappropriateNameException;

import java.lang.reflect.Field;

public class LengthAnnotationProcessor {
    public <T> LengthAnnotationProcessor(Field field, T t) throws InappropriateNameException, IllegalAccessException {
        field.setAccessible(true);
        String name = (String) field.get(t);
        int nameFieldLen = name.length();
        Length length = field.getAnnotation(Length.class);
        if (nameFieldLen < length.min() || nameFieldLen > length.max()) {
            throw new InappropriateNameException("Inappropriate Name , please try again :)");
        }
    }


}
