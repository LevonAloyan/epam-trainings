package com.epam.javatrainings.annotation.processors;

import com.epam.javatrainings.annotation.Error;
import com.epam.javatrainings.annotation.anotations.Max;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MaxProcessor {

    private static final List<Error> errors = new ArrayList<>();

    public static <T> List<Error> validate(T t) {
        Error error ;
        String message;
        Class<?> clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Max.class)) {
                field.setAccessible(true);
                message = validateMax(field, t);
                if (message != null){
                    error = new Error(field.getName(),message);
                    errors.add(error);
                }
            }
        }
        return errors;
    }


    private static <T> String validateMax(Field field, T t) {
        String message = null;
        try {
            Object value = field.get(t);
            Max max = field.getAnnotation(Max.class);
            int maxLimit = max.value();
            if (value instanceof Integer) {
                message = createErrorMessage((int) value, maxLimit);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return message;
    }

    private static String createErrorMessage(int value, int maxLimit) {
        String message = null;
        if (value > maxLimit) {
            message = "The " + value + " is greater than max limit(" + maxLimit + ")";

        }
        return message;
    }
}
