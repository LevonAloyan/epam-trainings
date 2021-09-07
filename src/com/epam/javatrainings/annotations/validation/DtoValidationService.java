package com.epam.javatrainings.annotations.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DtoValidationService {
    private DtoValidationService() {
        throw new IllegalStateException("No instances");
    }

    public static List<String> validate(CustomerDto customer) throws IllegalAccessException {
        List<String> errors = new ArrayList<String>();

        // Get Class object corresponding to customer object
        Class<?> customerClass = customer.getClass();

        // Get fields of the customer class
        Field [] fields = customerClass.getDeclaredFields();
        for (Field field : fields) {
            // If the field is declared as private change its accessibility in order to read field's value
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }

            errors.addAll(validateField(field, customer));
        }

        return errors;
    }

    private static List<String> validateField(Field field, CustomerDto customer) throws IllegalAccessException {
        List<String> fieldErrors = new ArrayList<String>();

        Annotation[] annotations = field.getAnnotations();
        for (Annotation annotation : annotations) {
            String valMessage = null;
            Object fieldValue = field.get(customer);

            if (annotation instanceof Length) {
                valMessage = new LengthAnnotationProcessor().validate(field.getAnnotation(Length.class), fieldValue);
            } else if (annotation instanceof Min) {
                valMessage = new MinAnnotationProcessor().validate(field.getAnnotation(Min.class), fieldValue);
            } else if (annotation instanceof Max) {
                valMessage = new MaxAnnotationProcessor().validate(field.getAnnotation(Max.class), fieldValue);
            } else if (annotation instanceof Email) {
                valMessage = new EmailAnnotationProcessor().validate(field.getAnnotation(Email.class), fieldValue);
            } else if (annotation instanceof Adulthood) {
                valMessage = new AdulthoodAnnotationProcessor(18).validate(field.getAnnotation(Adulthood.class), fieldValue);
            }

            if (valMessage != null) {
                fieldErrors.add("Field Name: " + field.getName() + ". Field value: " + fieldValue + ". Message: " + valMessage);
            }

        }

        return fieldErrors;
    }
}
