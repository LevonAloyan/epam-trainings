package com.epam.javatrainings.annotation.adulthood;

import com.epam.javatrainings.annotation.exception.IllegalAdultException;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class AdulthoodAnnotationProcessor {

    public static <T> void validateAge(T t)
            throws IllegalAccessException, IllegalAdultException {
        Field[] fields = t.getClass().getFields();
        LocalDate localDate;
        for (Field field : fields) {
            if (field.isAnnotationPresent(Adulthood.class)) {
                field.setAccessible(true);
                localDate = (LocalDate) field.get(t);

                int birthDate = localDate.getYear();
                int currentDate = LocalDate.now().getYear();
                if (currentDate - birthDate < 18 || field.get(t) == null) {
                    throw new IllegalAdultException("Check your age: must be more than or equal to 18");
                }
            }
        }
    }
}

