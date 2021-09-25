package com.epam.javatrainings.genericannotations.util.validators;

import com.epam.javatrainings.genericannotations.annotations.Adulthood;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;

public class AdulthoodValidator<T> {

    private AdulthoodValidator() {
    }

    public static <T> boolean validateAdulthood(T t, List<String> errorMessages) {
        boolean isValid = true; //It means that is no annotation - no restriction
        try {
            Field[] fields = t.getClass().getDeclaredFields();
            Field birthDate = null;
            for (Field field : fields) {
                if (field.isAnnotationPresent(Adulthood.class)) {
                    birthDate = field;
                    birthDate.setAccessible(true);
                    break;
                }
            }
            LocalDate value = (LocalDate) birthDate.get(t);
            int birthYear = value.getYear();
            int now = LocalDate.now().getYear();
            int age = now - birthYear;
            if (age < 18) {
                isValid = false;
                String message = birthDate.getDeclaredAnnotation(Adulthood.class).message();
                errorMessages.add(message);
            }
        } catch (IllegalAccessException e) {
            System.out.println("Field not found");
        }
        return isValid;
    }
}
