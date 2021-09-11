package com.epam.javatrainings.annotation.annotationValidator;

import com.epam.javatrainings.annotation.customAnnotation.Min;
import com.epam.javatrainings.annotation.dto.CustomerDto;

import java.lang.reflect.Field;

/**
 * Created by Hayk on 12.09.2021.
 */
public class MinValidator implements FieldValidator<CustomerDto> {
    @Override
    public void check(CustomerDto obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Min.class)) {
                field.setAccessible(true);
                try {
                    int value = (int) field.get(obj);
                    Min annotation = field.getDeclaredAnnotation(Min.class);
                    if (value < annotation.value()) {
                        throw new RuntimeException("Min cheking failed");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
