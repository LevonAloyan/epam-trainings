package com.epam.javatrainings.annotation.annotationValidator;

import com.epam.javatrainings.annotation.customAnnotation.Length;
import com.epam.javatrainings.annotation.dto.CustomerDto;

import java.lang.reflect.Field;

/**
 * Created by Hayk on 12.09.2021.
 */
public class LengthValidator implements FieldValidator<CustomerDto> {

    @Override
    public void check(CustomerDto obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Length.class)) {
                field.setAccessible(true);
                try {
                    String fieldStr = (String) field.get(obj);
                    Length annotation = field.getDeclaredAnnotation(Length.class);
                    if (fieldStr.length() < annotation.min() || fieldStr.length() > annotation.max()) {
                        throw new RuntimeException("Length cheking failed");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
