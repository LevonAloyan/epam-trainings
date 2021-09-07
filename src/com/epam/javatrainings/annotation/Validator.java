package com.epam.javatrainings.annotation;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    void validate(CustomerDto instance) {
        try {
            Field f = instance.getClass().getDeclaredField("name");
            Field email = instance.getClass().getDeclaredField("email");
            Field birthDay = instance.getClass().getDeclaredField("birthDay");
            Field discount = instance.getClass().getDeclaredField("discountRate");
            if (f.isAnnotationPresent(Length.class)) {
                f.setAccessible(true);
                String name = (String) f.get(instance);
                int nameFieldLen = name.length();
                Length length = f.getAnnotation(Length.class);
                if (nameFieldLen < length.min() || nameFieldLen > length.max()) {
                    System.out.println("You entered wrong length please fix it");
                }
            }
            if (email.isAnnotationPresent(Email.class)) {
                email.setAccessible(true);
                String emailStr = (String) email.get(instance);
                String regex = "^(.+)@(.+)$";
                if (!emailStr.matches(regex)) {
                    System.out.println("You entered wrong email address");
                }
            }
            if (birthDay.isAnnotationPresent(Adulthood.class)) {
                birthDay.setAccessible(true);
                LocalDate localDate = (LocalDate) birthDay.get(instance);
                int birthDayPerson = localDate.getYear();
                int currentYear = LocalDate.now().getYear();
                if ( currentYear - birthDayPerson < 18) {
                    System.out.println("You are a minor");
                }
            }
            if (discount.isAnnotationPresent(Min.class) && discount.isAnnotationPresent(Max.class)) {
                discount.setAccessible(true);
                Integer discountRate = (Integer) discount.get(instance);
                if (discountRate < 0 || discountRate > 100) {
                    System.out.println("You entered wrong discount rate");
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException exc) {
            System.out.println("Field not found");
        }
    }


}
