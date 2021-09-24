package com.epam.javatrainings.annotation;

import java.lang.reflect.Field;


public class MaxAnnotationProcessor {

    boolean maxValidate(CustomerDto instance) {
        try {
            Field discount = instance.getClass().getDeclaredField("discountRate");
            if (discount.isAnnotationPresent(Max.class)) {
                discount.setAccessible(true);
                Integer discountRate = (Integer) discount.get(instance);
                if (discountRate > 100) {
                    return false;
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException exc) {
            System.out.println("Field not found");
        }
        return true;
    }

}
