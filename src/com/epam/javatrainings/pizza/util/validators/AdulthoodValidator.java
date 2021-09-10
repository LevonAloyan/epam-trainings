package com.epam.javatrainings.pizza.util.validators;

import com.epam.javatrainings.pizza.annotations.Adulthood;
import com.epam.javatrainings.pizza.dto.Dto;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;

public class AdulthoodValidator {

    private AdulthoodValidator() {
    }

    public static boolean validateAdulthood(Dto dto, List<String> errorMessages) {
        boolean isValid = false;
        try {
            Field field = dto.getClass().getDeclaredField("birthDate");
            if (field.isAnnotationPresent(Adulthood.class)) {
                field.setAccessible(true);
                LocalDate value = (LocalDate) field.get(dto);
                int birthYear = value.getYear();
                int now = LocalDate.now().getYear();
                int age = now - birthYear;
                if (age < 18) {
                    String message = field.getDeclaredAnnotation(Adulthood.class).message();
                    errorMessages.add(message);
                } else isValid = true;
            } else isValid = true; // It means that is no annotation - no restriction
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Field not found");
        }
        return isValid;
    }
}
