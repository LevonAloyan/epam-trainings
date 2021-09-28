package com.epam.javatrainings.annotations.validation;

import java.lang.annotation.Annotation;

public abstract class AnnotationProcessor {
    abstract String validate(Annotation annotation, Object value);
}
