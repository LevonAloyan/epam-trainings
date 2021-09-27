package com.epam.javatrainings.validation;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAnnotationProcessor extends AnnotationProcessor {

    private final Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    @Override
    String validate(Field field, Object obj) {
        if(!(obj instanceof String)) {
            throw new IllegalArgumentException(obj + " is not String type to be validated for the Email field");
        }

        Matcher matcher = pattern.matcher((String)obj);
        String msg = "";

        if(!matcher.matches()) {
            msg += "Not valid! Given email does not match the required Regexp";
        }

        return msg;
    }
}
