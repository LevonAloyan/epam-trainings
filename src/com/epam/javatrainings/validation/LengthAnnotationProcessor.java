package com.epam.javatrainings.validation;

import java.lang.reflect.Field;

public class LengthAnnotationProcessor extends AnnotationProcessor {

    @Override
     String validate(Field field, Object obj) {
        int min = field.getAnnotation(Length.class).min();
        int max = field.getAnnotation(Length.class).max();
        String msg = "";

        if(!(obj instanceof String)) {
            throw new IllegalArgumentException(obj + " is not String type to be validated for the Name field");
        }

        if(obj instanceof String) {
            int length = ((String) obj).length();

            if (length < min || length > max) {
               msg += "Not valid! Length of " + obj + " (" + length + ") is out of the required range [" + min + ", " + max + "]";
            }
        }

        return msg;
    }
}
