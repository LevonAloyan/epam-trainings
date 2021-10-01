package com.epam.javatrainings.validation;

import java.lang.reflect.Field;

public abstract class AnnotationProcessor {

    abstract String validate(Field field, Object obj);
}
