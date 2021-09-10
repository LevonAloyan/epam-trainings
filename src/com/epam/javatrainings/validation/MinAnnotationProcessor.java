package com.epam.javatrainings.validation;

import java.lang.reflect.Field;

public class MinAnnotationProcessor extends AnnotationProcessor {

    @Override
    String validate(Field field, Object obj) {
        if(!(obj instanceof Integer)) {
            throw new IllegalArgumentException(obj + " is not Integer type to be validated for the Min field");
        }

        String msg = "";
        int min = field.getAnnotation(Min.class).value();

        if((Integer)obj < min) {
            msg += "Not valid! " + obj + " is less than " + min;
        }

        return msg;
    }
}
