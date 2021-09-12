package com.epam.javatrainings.validation.validator;

import com.epam.javatrainings.validation.annotations.Max;
import com.epam.javatrainings.validation.exceptions.AppRuntimeException;

import java.lang.annotation.Annotation;

public class MaxValidator implements Validator {

    @Override
    public void validate(Annotation a, Object o) {
        Max max = null;
        Integer value = null;
        try {
            max = (Max) a;
            value = (Integer) o;
        } catch (ClassCastException e) {
            throw new AppRuntimeException("Incompatible constraint " + Max.class.getSimpleName(), e);
        }

        if (value > max.value()) {
            throw new AppRuntimeException("Max value constraint violation");
        }
    }
}
