package com.epam.javatrainings.annotations.validation;

public abstract class BoundaryAnnotationProcessor extends AnnotationProcessor {

    protected double getDoubleValue(Number n) {
        return n.doubleValue();
    }
}
