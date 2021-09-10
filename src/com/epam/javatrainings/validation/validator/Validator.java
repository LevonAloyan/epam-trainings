package com.epam.javatrainings.validation.validator;

import java.lang.annotation.Annotation;

public interface Validator {
    void validate(Annotation a, Object o);
}
