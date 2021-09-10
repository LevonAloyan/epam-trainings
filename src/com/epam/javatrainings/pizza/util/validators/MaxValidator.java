package com.epam.javatrainings.pizza.util.validators;

import com.epam.javatrainings.pizza.annotations.Max;
import com.epam.javatrainings.pizza.annotations.Min;
import com.epam.javatrainings.pizza.dto.Dto;

import java.lang.reflect.Field;
import java.util.List;

public class MaxValidator {

    private MaxValidator() {
    }

    public static boolean validateMax(Dto dto, List<String> errorMessages) {
        boolean isValid = false;
        try {
            Field discountRate = dto.getClass().getDeclaredField("discountRate");
            if (discountRate.isAnnotationPresent(Max.class)) {
                discountRate.setAccessible(true);
                int value = (int) discountRate.get(dto);
                int declaredValue = discountRate.getDeclaredAnnotation(Min.class).value();
                if (value > declaredValue) {
                    String message = discountRate.getDeclaredAnnotation(Max.class).message();
                    errorMessages.add(message);
                } else isValid = true;
            }else isValid = true; // It means that is no annotation - no restriction
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Field not found");
        }
        return isValid;
    }
}
