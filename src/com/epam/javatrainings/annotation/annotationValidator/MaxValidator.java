package com.epam.javatrainings.annotation.annotationValidator;

import com.epam.javatrainings.annotation.customAnnotation.Max;
import com.epam.javatrainings.annotation.dto.CustomerDto;

import java.lang.reflect.Field;

/**
 * Created by Hayk on 12.09.2021.
 */
public class MaxValidator implements FieldValidator<CustomerDto> {
    @Override
    public void check(CustomerDto obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        ;
        for (Field field : fields) {
            if (field.isAnnotationPresent(Max.class)) {
                field.setAccessible(true);
                try {
                    int value = (int) field.get(obj);
                    Max annotation = field.getDeclaredAnnotation(Max.class);
                    if (value > annotation.value()) {
                        throw new RuntimeException("Max cheking failed");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
