package com.epam.javatrainings.annotation.max;

import com.epam.javatrainings.annotation.exception.IllegalMinMaxValueException;

import java.lang.reflect.Field;

public class MaxAnnotationProcessor {
    public static <T> void validateMaxValue(T t) throws IllegalAccessException, IllegalMinMaxValueException {
        Field[] fields = t.getClass().getFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Max.class)) {
                field.setAccessible(true);
                Object o = field.get(t);
                if (!(o instanceof Number)) {
                    throw new IllegalStateException();
                }

                Max max = field.getAnnotation(Max.class);
                Integer i = (Integer) field.get(t);
                if (i > max.max()) {
                    throw new IllegalMinMaxValueException("Check value less than max value");
                }
            }
        }
    }
}

