package com.epam.javatrainings.annotations.validation;

import java.lang.annotation.Annotation;

public class MinAnnotationProcessor extends BoundaryAnnotationProcessor {
    @Override
    String validate(Annotation annotation, Object value) {
        if (!(value instanceof Number)) {
            throw new IllegalStateException();
        }

        int min = ((Min)annotation).value();
        double dValue = getDoubleValue((Number)value);

        if (dValue < min) {
            return "Field value is less than minimum value "  + min + ".";
        }

        return null;
    }
}
