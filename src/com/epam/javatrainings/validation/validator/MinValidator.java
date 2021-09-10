package com.epam.javatrainings.validation.validator;

import com.epam.javatrainings.validation.annotations.Min;
import com.epam.javatrainings.validation.exceptions.AppRuntimeException;

import java.lang.annotation.Annotation;

public class MinValidator implements Validator {

    @Override
    public void validate(Annotation a, Object o) {
        Min min = null;
        Integer value = null;
        try {
            min = (Min) a;
            value = (Integer) o;
        } catch (ClassCastException e) {
            throw new AppRuntimeException("Incompatible constraint " + Min.class.getSimpleName(), e);
        }

        if (value < min.value()) {
          throw new IllegalArgumentException("Min value constraint violation");
        }
    }
}
