package com.epam.javatrainings.annotations.validation;

import java.lang.annotation.Annotation;

public class MaxAnnotationProcessor extends AnnotationProcessor {
    @Override
    String validate(Annotation annotation, Object value) {
        if (!(value instanceof Number)) {
            throw new IllegalStateException();
        }

        int max = ((Max)annotation).value();
        double dValue = 0;

        if (value instanceof Byte) {
            dValue = (Byte) value;
        } else if (value instanceof Short) {
            dValue = (Short) value;
        } else if (value instanceof Integer) {
            dValue = (Integer) value;
        } else if (value instanceof Long) {
            dValue = (Long) value;
        } else if (value instanceof Float) {
            dValue = (Float) value;
        } else if (value instanceof Double) {
            dValue = (Double) value;
        }

        if (dValue > max) {
            return "Field value is greater than maximum value "  + max + ".";
        }

        return null;
    }
}
