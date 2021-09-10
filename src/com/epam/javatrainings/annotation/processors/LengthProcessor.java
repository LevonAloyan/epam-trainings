package com.epam.javatrainings.annotation.processors;

import com.epam.javatrainings.annotation.Error;
import com.epam.javatrainings.annotation.anotations.Length;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class LengthProcessor {

    private static final List<Error> errors = new ArrayList<>();

    public static <T> List<Error> validateLength(T t){
        Error error ;
        String message;
        Class<?> clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields){
            if (field.isAnnotationPresent(Length.class)){
                field.setAccessible(true);
                message = validateLength(field,t);
                if (message != null){
                    error = new Error(field.getName(),message);
                    errors.add(error);
                }
            }
        }
        return errors;
    }

    private static <T> String validateLength(Field field, T t) {
        String message = null;
        try {
            Object value = field.get(t);
            Length length = field.getAnnotation(Length.class);
            int min = length.min();
            int max = length.max();
            if (value instanceof String){
                message = createErrorMessage((String) value,min,max);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return message;

    }

    private static String createErrorMessage(String value, int min, int max) {
        String message = null;
        if (value.length() < min){
            message = "The name length less than " + min;
        } else if (value.length() > max){
            message = "The name length greater than " + max;
        }

        return message;
    }
}
