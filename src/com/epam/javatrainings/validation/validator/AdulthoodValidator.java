package com.epam.javatrainings.validation.validator;

import com.epam.javatrainings.validation.annotations.Adulthood;
import com.epam.javatrainings.validation.exceptions.AppRuntimeException;

import java.lang.annotation.Annotation;
import java.time.LocalDate;

public class AdulthoodValidator implements Validator {

    @Override
    public void validate(Annotation a, Object o) {
        Adulthood adulthood = null;
        LocalDate value = null;
        try {
            adulthood = (Adulthood) a;
            value = (LocalDate) o;
        } catch (ClassCastException e) {
            throw new AppRuntimeException("Incompatible constraint " +  Adulthood.class.getSimpleName(), e);
        }

        if (value.getYear() - LocalDate.now().getYear() < 18) {
            throw new AppRuntimeException("Age constraint violation");
        }
    }
}
