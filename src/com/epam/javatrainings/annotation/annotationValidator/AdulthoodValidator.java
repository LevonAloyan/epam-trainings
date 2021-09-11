package com.epam.javatrainings.annotation.annotationValidator;

import com.epam.javatrainings.annotation.customAnnotation.Adulthood;
import com.epam.javatrainings.annotation.dto.CustomerDto;

import java.lang.reflect.Field;
import java.time.LocalDate;

/**
 * Created by Hayk on 10.09.2021.
 */
public class AdulthoodValidator implements FieldValidator<CustomerDto> {

    @Override
    public void check(CustomerDto obj) {
        Field field;
        try {
            field = obj.getClass().getDeclaredField("birthDay");
            if (field.isAnnotationPresent(Adulthood.class)) {
                field.setAccessible(true);
                LocalDate birthDay = (LocalDate) field.get(obj);
                if (LocalDate.now().getYear() - birthDay.getYear() < 18) {
                    throw new RuntimeException("Adulthood cheking failed");
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
