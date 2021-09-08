package com.epam.javatrainings.annotations.validation;

public abstract class BoundaryAnnotationProcessor extends AnnotationProcessor {

    protected double getDoubleValue(Number n) {
        double dValue = 0;

        if (n instanceof Byte) {
            dValue = (Byte) n;
        } else if (n instanceof Short) {
            dValue = (Short) n;
        } else if (n instanceof Integer) {
            dValue = (Integer) n;
        } else if (n instanceof Long) {
            dValue = (Long) n;
        } else if (n instanceof Float) {
            dValue = (Float) n;
        } else if (n instanceof Double) {
            dValue = (Double) n;
        }

        return dValue;
    }
}
