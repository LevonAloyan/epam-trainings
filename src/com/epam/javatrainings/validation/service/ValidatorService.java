package com.epam.javatrainings.validation.service;

import com.epam.javatrainings.validation.service.error.Error;
import com.epam.javatrainings.validation.validator.Validator;
import com.epam.javatrainings.validation.validator.registry.Registry;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class ValidatorService {
    private final Registry registry = Registry.getInstance();
    private static ValidatorService instance;

    public static ValidatorService getInstance() {
        if (instance == null) {
            instance = new ValidatorService();
        }
        return instance;
    }

    private ValidatorService() {

    }

    public  <T> List<Error> validate(T dto) throws IllegalAccessException {
        Class<?> clazz  = dto.getClass();
        Field[] fields = clazz.getDeclaredFields();
        List<Error> errors = new ArrayList<>();

        for(Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(dto);
            Annotation[] annotations = field.getAnnotations();

            for (Annotation annotation : annotations) {
                Class<? extends Annotation> annoType = annotation.annotationType();
                Validator validator = registry.getValidator(annoType);
                try {
                    validator.validate(annotation, value);
                } catch (RuntimeException e) {
                    errors.add(new Error(e.getMessage() + " on field " + field.getName()));
                }
            }
        }

        return errors;
    }
}
