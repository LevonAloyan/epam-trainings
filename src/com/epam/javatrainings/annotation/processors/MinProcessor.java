package com.epam.javatrainings.annotation.processors;

import com.epam.javatrainings.annotation.Error;
import com.epam.javatrainings.annotation.anotations.Min;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MinProcessor {

    private static final List<Error> errors = new ArrayList<>();

    public static <T> List<Error> validate(T t){
        Error error ;
        String message;
        Class<?> clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields){
            if (field.isAnnotationPresent(Min.class)){
                field.setAccessible(true);
                message = validateMin(field,t);
                if (message != null){
                    error = new Error(field.getName(),message);
                    errors.add(error);
                }
            }
        }
        return errors;
    }


    private static  <T> String validateMin(Field field, T t) {
        String message = null;
        try {
            Object value = field.get(t);
            Min min = field.getAnnotation(Min.class);
            int minLimit = min.value();
            if (value instanceof Integer){
                message = createErrorMessage((int) value,minLimit);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return message;
    }

    private static String createErrorMessage(int value, int minLimit) {
        String message = null;
        if (value < minLimit){
            message = "The " + value + " is less than min limit(" + minLimit + ")";
        }
        return message;
    }
}
