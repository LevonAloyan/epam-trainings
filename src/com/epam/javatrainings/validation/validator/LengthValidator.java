package com.epam.javatrainings.validation.validator;

import com.epam.javatrainings.validation.annotations.Length;
import com.epam.javatrainings.validation.exceptions.AppRuntimeException;

import java.lang.annotation.Annotation;

public class LengthValidator implements Validator {

    @Override
    public void validate(Annotation a, Object o) {
        Length length = null;
        String value = null;
        try {
            length = (Length) a;
            value = (String) o;
        } catch (ClassCastException e) {
            throw new AppRuntimeException("Incompatible constraint " + Length.class.getSimpleName(), e);
        }

        if (value.length() > length.max() || value.length() < length.min()) {
            throw new AppRuntimeException("Length constraint violation");
        }
    }
}
