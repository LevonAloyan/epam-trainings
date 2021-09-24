package com.epam.javatrainings.annotation;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class AdulthoodAnnotationProcessor {

   boolean adulthoodValidate(CustomerDto instance) {
        try {
            Field birthDay = instance.getClass().getDeclaredField("birthDay");
            if (birthDay.isAnnotationPresent(Adulthood.class)) {
                birthDay.setAccessible(true);
                LocalDate localDate = (LocalDate) birthDay.get(instance);
                int birthDayPerson = localDate.getYear();
                int currentYear = LocalDate.now().getYear();
                if ( currentYear - birthDayPerson < 18) {
                    return false;
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException exc) {
            System.out.println("Field not found");
        }
        return true;
    }


}
