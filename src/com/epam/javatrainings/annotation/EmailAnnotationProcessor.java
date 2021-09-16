package com.epam.javatrainings.annotation;

import java.lang.reflect.Field;

public class EmailAnnotationProcessor {

    boolean emailValidate(CustomerDto instance) {
        try {
            Field email = instance.getClass().getDeclaredField("email");
            if (email.isAnnotationPresent(Email.class)) {
                email.setAccessible(true);
                String emailStr = (String) email.get(instance);
                String regex = "^(.+)@(.+)$";
                if (!emailStr.matches(regex)) {
                    return false;
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException exc) {
            System.out.println("Field not found");
        }
        return true;
    }
}
