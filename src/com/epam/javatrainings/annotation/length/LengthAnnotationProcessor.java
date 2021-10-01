package com.epam.javatrainings.annotation.length;

import com.epam.javatrainings.annotation.exception.IllegalLengthException;

import java.lang.reflect.Field;
import java.util.Collection;

public class LengthAnnotationProcessor {
    public static <T> void validateLength(T t) throws IllegalAccessException, IllegalLengthException {
        Field[] fields = t.getClass().getFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Length.class)) {
                field.setAccessible(true);
                Object o = field.get(t);

                if (o == null) {
                    throw new NullPointerException();
                }

                if (!(o instanceof Object[] || o instanceof String || o instanceof Collection)) {
                    throw new IllegalAccessException();
                }

                int fieldLength = 0;

                if (o instanceof Collection) {
                    fieldLength = ((Collection) o).size();
                }

                if (o instanceof String) {
                    fieldLength = ((String) o).length();
                }

                if (o instanceof Object[]) {
                    fieldLength = ((Object[]) o).length;
                }

                Length length = field.getAnnotation(Length.class);

                if (fieldLength < length.min() || fieldLength > length.max()) {
                    throw new IllegalLengthException("Illegal length: fix min and max values");
                }
            }
        }
    }
}

