package com.epam.javatrainings.annotation;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class MinAnnotationProcessor {

    boolean minValidate(CustomerDto instance) {
        try {
            Field discount = instance.getClass().getDeclaredField("discountRate");
            if (discount.isAnnotationPresent(Min.class)) {
                discount.setAccessible(true);
                Integer discountRate = (Integer) discount.get(instance);
                if (discountRate < 0 ) {
                    return false;
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException exc) {
            System.out.println("Field not found");
        }
        return true;
    }

}
