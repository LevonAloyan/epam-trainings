package com.epam.javatrainings.annotation;

import java.lang.reflect.Field;

public class LengthAnnotationProcessor {

    boolean lengthValidate(CustomerDto instance) {
        try {
            Field f = instance.getClass().getDeclaredField("name");
            if (f.isAnnotationPresent(Length.class)) {
                f.setAccessible(true);
                String name = (String) f.get(instance);
                int nameFieldLen = name.length();
                Length length = f.getAnnotation(Length.class);
                if (nameFieldLen < length.min() || nameFieldLen > length.max()) {
                    return false;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return true;
    }
}