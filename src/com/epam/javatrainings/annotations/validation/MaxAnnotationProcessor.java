package com.epam.javatrainings.annotations.validation;

import java.lang.annotation.Annotation;

public class MaxAnnotationProcessor extends BoundaryAnnotationProcessor {
    @Override
    String validate(Annotation annotation, Object value) {
        if (!(value instanceof Number)) {
            throw new IllegalStateException();
        }

        int max = ((Max)annotation).value();
        double dValue = getDoubleValue((Number)value);

        if (dValue > max) {
            return "Field value is greater than maximum value "  + max + ".";
        }

        return null;
    }
}
