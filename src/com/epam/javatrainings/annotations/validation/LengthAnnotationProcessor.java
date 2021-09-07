package com.epam.javatrainings.annotations.validation;

import java.lang.annotation.Annotation;
import java.util.Collection;

public class LengthAnnotationProcessor extends AnnotationProcessor {

    @Override
    String validate(Annotation annotation, Object value) {
        if (!(value instanceof Object [] || value instanceof String || value instanceof Collection)) {
            throw new IllegalStateException();
        }

        int length = -1;

        if (value instanceof String) {
            length = ((String) value).length();
        }

        if (value instanceof Collection) {
            length = ((Collection) value).size();
        }

        if (value instanceof Object[]) {
            length = ((Object[]) value).length;
        }

        int min = ((Length)annotation).min();
        int max = ((Length)annotation).max();

        if (length < min || length > max) {
            return "The length of the field value is out of the range [" + min + ", " + max + "].";
        }

        return null;
    }
}
