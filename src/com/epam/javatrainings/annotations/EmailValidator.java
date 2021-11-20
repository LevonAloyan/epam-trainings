package com.epam.javatrainings.annotations;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.reflect.Field;

public class EmailValidator {
    public static void validate(Field f,Object obj) throws AnnotationTypeMismatchException
    {
        f.setAccessible(true);
        if(!f.isAnnotationPresent(Email.class))
            throw new RuntimeException("No such Annotation");
        try {
            String email=(String) f.get(obj);
            f.getAnnotation(Email.class);
            if(!email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"))
                System.out.println("Email invalid");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
