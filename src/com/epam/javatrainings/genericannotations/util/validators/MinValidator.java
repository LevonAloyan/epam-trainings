package com.epam.javatrainings.genericannotations.util.validators;

import com.epam.javatrainings.genericannotations.annotations.Min;

import java.lang.reflect.Field;
import java.util.List;

public class MinValidator<T> {

    private MinValidator() {
    }

    public static <T> boolean validateMin(T t, List<String> errorMessages) {
        boolean isValid = true; //It means that is no annotation - no restriction
        try {
            Field[] fields = t.getClass().getDeclaredFields();
            Field val = null;
            for (Field field : fields) {
                if (field.isAnnotationPresent(Min.class)) {
                    val = field;
                    val.setAccessible(true);
                    break;
                }
            }

            int value = (int) val.get(t);
            int declaredValue = val.getDeclaredAnnotation(Min.class).value();
            if (value <  declaredValue) {
                isValid = false;
                String message = val.getDeclaredAnnotation(Min.class).message();
                errorMessages.add(message);
            }
        } catch (IllegalAccessException e) {
            System.out.println("Field not found");
        }
        return isValid;
    }
}
