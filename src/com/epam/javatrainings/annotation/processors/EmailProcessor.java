package com.epam.javatrainings.annotation.processors;

import com.epam.javatrainings.annotation.Error;
import com.epam.javatrainings.annotation.anotations.Email;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailProcessor {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final List<Error> errors = new ArrayList<>();

    public static <T> List<Error> validateEmail(T t){
        Error error ;
        String message;
        Class<?> clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields){
            if (field.isAnnotationPresent(Email.class)){
                field.setAccessible(true);
                message = validateEmail(field,t);
                if (message != null){
                    error = new Error(field.getName(),message);
                    errors.add(error);
                }
            }
        }

        return errors;
    }



    private static <T> String validateEmail(Field field, T t) {
        String message = null;
        try {
            Object value = field.get(t);
            if (value instanceof String){
               message = createErrorMessage((String) value);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
       return message;
    }

    private static String createErrorMessage(String value) {
        String message = null;
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(value);
        if (!matcher.find()){
            message = "The email is invalid";
        }

        return message;
    }
}
