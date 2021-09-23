package com.epam.javatrainings.annotation.email;

import com.epam.javatrainings.annotation.exception.IllegalEmailException;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAnnotationProcessor {
    public static <T> void validateEmail(T t) throws IllegalAccessException, IllegalEmailException {
        String regExp = "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";

        Pattern p = Pattern.compile(regExp);
        Field[] fields = t.getClass().getFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Email.class)) {
                field.setAccessible(true);
                Matcher matcher = p.matcher((String) field.get(t));

                if (!matcher.matches()) {
                    throw new IllegalEmailException("Check mail rules");
                }
            }
        }
    }
}

