package com.epam.javatrainings.annotation.annotationValidator;

import com.epam.javatrainings.annotation.customAnnotation.Email;
import com.epam.javatrainings.annotation.dto.CustomerDto;
import com.epam.javatrainings.classdecomposition.validator.Validator;

import java.lang.reflect.Field;

/**
 * Created by Hayk on 12.09.2021.
 */
public class EmailValidator implements FieldValidator<CustomerDto> {
    @Override
    public void check(CustomerDto obj) {
        Field field;
        try {
            field = obj.getClass().getDeclaredField("email");
            if (field.isAnnotationPresent(Email.class)) {
                field.setAccessible(true);
                String email = (String) field.get(obj);
                if (!Validator.isEmail(email)) {
                    throw new RuntimeException("Email cheking failed");
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
