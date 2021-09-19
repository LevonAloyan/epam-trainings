package com.epam.javatrainings.validation;

import java.lang.reflect.Field;

public interface AnnotationProcessor {

    String validate(Field field, Object obj);
}
