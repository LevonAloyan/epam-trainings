package com.epam.javatrainings.validation.validator;

import com.epam.javatrainings.validation.annotations.Email;
import com.epam.javatrainings.validation.exceptions.AppRuntimeException;

import java.lang.annotation.Annotation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements Validator {
    private static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

    @Override
    public void validate(Annotation a, Object o) {
        Email email = null;
        String value = null;
        try {
            email = (Email) a;
            value = (String) o;
        } catch (ClassCastException e) {
            throw new AppRuntimeException("Incompatible constraint " + Email.class.getSimpleName(), e);
        }

        Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        if(!matcher.matches()) {
            throw new IllegalArgumentException("Email pattern constraint violation");
        }
    }

}
