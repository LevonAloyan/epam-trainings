package com.epam.javatrainings.genericannotations.util.validators;

import com.epam.javatrainings.genericannotations.annotations.Max;

import java.lang.reflect.Field;
import java.util.List;

public class MaxValidator<T> {

    private MaxValidator() {
    }

    public static <T> boolean validateMax(T t, List<String> errorMessages) {
        boolean isValid = true; //It means that is no annotation - no restriction
        try {
            Field[] fields = t.getClass().getDeclaredFields();
            Field val = null;
            for (Field field : fields) {
                if (field.isAnnotationPresent(Max.class)) {
                    val = field;
                    val.setAccessible(true);
                    break;
                }
            }

            int value = (int) val.get(t);
            int declaredValue = val.getDeclaredAnnotation(Max.class).value();
            if (value > declaredValue) {
                isValid = false;
                String message = val.getDeclaredAnnotation(Max.class).message();
                errorMessages.add(message);
            }
        } catch (IllegalAccessException e) {
            System.out.println("Field not found");
        }
        return isValid;
    }
}
