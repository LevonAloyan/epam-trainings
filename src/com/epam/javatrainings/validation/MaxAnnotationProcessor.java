package com.epam.javatrainings.validation;

import java.lang.reflect.Field;

public class MaxAnnotationProcessor extends AnnotationProcessor {

    @Override
    String validate(Field field, Object obj) {
        if(!(obj instanceof Integer)) {
            throw new IllegalArgumentException(obj + " is not Integer type to be validated for the Max field");
        }

        String msg = "";
        int max = field.getAnnotation(Max.class).value();

        if((Integer)obj > max) {
            msg += "Not valid! " + obj + " is greater than " + max;
        }

        return msg;
    }
}
