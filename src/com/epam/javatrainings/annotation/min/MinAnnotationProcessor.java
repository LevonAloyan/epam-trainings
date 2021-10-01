package com.epam.javatrainings.annotation.min;

import com.epam.javatrainings.annotation.exception.IllegalMinMaxValueException;

import java.lang.reflect.Field;

public class MinAnnotationProcessor {
    public static <T> void validateMinValue(T t) throws IllegalAccessException, IllegalMinMaxValueException {
        Field[] fields = t.getClass().getFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Min.class)) {
                field.setAccessible(true);
                Object o = field.get(t);
                if (!(o instanceof Number)) {
                    throw new IllegalStateException();
                }

                Min min = field.getAnnotation(Min.class);
                Integer i = (Integer) field.get(t);
                if (i > min.min()) {
                    throw new IllegalMinMaxValueException("Check value more than min value");
                }
            }
        }
    }
}

