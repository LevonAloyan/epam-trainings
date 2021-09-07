package com.epam.javatrainings.annotations.validation;

import java.lang.annotation.Annotation;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAnnotationProcessor extends AnnotationProcessor {
    @Override
    String validate(Annotation annotation, Object value) {
        if (!(value instanceof String)) {
            throw new IllegalStateException();
        }

        final String emailRegex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher((String)value);

        if (!matcher.matches()) {
            return "Field value is not matching to the predefined regular expression.";
        }

        return null;
    }
}
