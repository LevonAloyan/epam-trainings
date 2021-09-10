package com.epam.javatrainings.pizza.util.validators;

import com.epam.javatrainings.pizza.annotations.Length;
import com.epam.javatrainings.pizza.dto.Dto;

import java.lang.reflect.Field;
import java.util.List;

public class LengthValidator {

    private LengthValidator() {
    }

    public static boolean validateLength(Dto dto, List<String> errorMessages) {
        boolean isValid = false;
        try {
            Field field = dto.getClass().getDeclaredField("name");
            if (field.isAnnotationPresent(Length.class)) {
                field.setAccessible(true);
                int min = field.getDeclaredAnnotation(Length.class).min();
                int max = field.getDeclaredAnnotation(Length.class).max();
                int allowedLength = max - min;
                String name = (String) field.get(dto);
                if (name.length() > allowedLength) {
                    String message = field.getDeclaredAnnotation(Length.class).message();
                    errorMessages.add(message);
                } else isValid = true;
            } else isValid = true; // It means that is no annotation - no restriction
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Field not found");
        }
        return isValid;
    }
}
