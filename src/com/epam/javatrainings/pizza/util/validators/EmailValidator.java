package com.epam.javatrainings.pizza.util.validators;

import com.epam.javatrainings.pizza.annotations.Email;
import com.epam.javatrainings.pizza.dto.Dto;

import java.lang.reflect.Field;
import java.util.List;
import java.util.regex.Pattern;

public class EmailValidator {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private EmailValidator() {
    }

    public static boolean validateEmail(Dto dto, List<String> errorMessages) {
        boolean isValid = false;
        try {
            Field email = dto.getClass().getDeclaredField("email");
            if (email.isAnnotationPresent(Email.class)) {
                email.setAccessible(true);
                String value = (String) email.get(dto);
                if (!VALID_EMAIL_ADDRESS_REGEX.matcher(value).matches()) {
                    String message = email.getDeclaredAnnotation(Email.class).message();
                    errorMessages.add(message);
                } else isValid = true;
            } else isValid = true; // It means that is no annotation - no restriction
        } catch (NoSuchFieldException | IllegalAccessException exc) {
            System.out.println("Field not found");
        }
        return isValid;
    }
}
