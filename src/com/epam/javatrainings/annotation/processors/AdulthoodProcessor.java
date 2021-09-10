package com.epam.javatrainings.annotation.processors;

import com.epam.javatrainings.annotation.Error;
import com.epam.javatrainings.annotation.anotations.Adulthood;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdulthoodProcessor {

    private static final int ADULTHOOD = 18;
    private static final List<Error> errors = new ArrayList<>();

    public static <T> List<Error> validate(T t){
        Error error ;
        String message;
        Class<?> clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields){
            if (field.isAnnotationPresent(Adulthood.class)){
                field.setAccessible(true);
                message = validateAdulthood(field,t);
                if (message != null){
                    error = new Error(field.getName(),message);
                    errors.add(error);
                }
            }
        }
        return errors;
    }

    private static  <T> String validateAdulthood(Field field, T t) {
        String message = null;
        try {
            Object value = field.get(t);
            if (value instanceof LocalDate){
                message = createErrorMessage((LocalDate) value);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return message;
    }

    private static String createErrorMessage(LocalDate value) {
        String message = null;
        if (LocalDate.now().compareTo(value) < ADULTHOOD){
            message = "Isn't adult";
        }
        return message;
    }

}
