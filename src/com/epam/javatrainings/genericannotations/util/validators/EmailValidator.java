package com.epam.javatrainings.genericannotations.util.validators;

import com.epam.javatrainings.genericannotations.annotations.Email;

import java.lang.reflect.Field;
import java.util.List;
import java.util.regex.Pattern;

public class EmailValidator<T> {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private EmailValidator() {
    }

    public static <T> boolean validateEmail(T t, List<String> errorMessages) {
        boolean isValid = true; //It means that is no annotation - no restriction
        try {
            Field[] fields = t.getClass().getDeclaredFields();
            Field email = null;
            for (Field field : fields) {
                if (field.isAnnotationPresent(Email.class)) {
                    email = field;
                    email.setAccessible(true);
                    break;
                }
            }
            String value = (String) email.get(t);
            if (!VALID_EMAIL_ADDRESS_REGEX.matcher(value).matches()) {
                isValid = false;
                String message = email.getDeclaredAnnotation(Email.class).message();
                errorMessages.add(message);
            }
        } catch (IllegalAccessException exc) {
            System.out.println("Field not found");
        }
        return isValid;
    }
}
