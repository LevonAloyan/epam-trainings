package com.epam.javatrainings.genericannotations.util.validators;

import com.epam.javatrainings.genericannotations.annotations.Length;

import java.lang.reflect.Field;
import java.util.List;

public class LengthValidator<T> {

    private LengthValidator() {
    }

    public static <T> boolean validateLength(T t, List<String> errorMessages) {
        boolean isValid = true; //It means that is no annotation - no restriction
        try {
            Field[] fields = t.getClass().getDeclaredFields();
            Field length = null;
            for (Field field : fields) {
                if (field.isAnnotationPresent(Length.class)) {
                    length = field;
                    length.setAccessible(true);
                    break;
                }
            }

            int min = length.getDeclaredAnnotation(Length.class).min();
            int max = length.getDeclaredAnnotation(Length.class).max();
            int allowedLength = max - min;
            String name = (String) length.get(t);
            if (name.length() > allowedLength) {
                isValid = false;
                String message = length.getDeclaredAnnotation(Length.class).message();
                errorMessages.add(message);
            }
        } catch (IllegalAccessException e) {
            System.out.println("Field not found");
        }
        return isValid;
    }
}
