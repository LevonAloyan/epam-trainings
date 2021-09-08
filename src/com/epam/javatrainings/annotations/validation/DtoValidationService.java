package com.epam.javatrainings.annotations.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DtoValidationService {
    private DtoValidationService() {
        throw new IllegalStateException("No instances");
    }

    private static Map<Class<?>, ? extends AnnotationProcessor> annotationProcessorMap = Map.of(
        Length.class, new LengthAnnotationProcessor(),
        Adulthood.class, new AdulthoodAnnotationProcessor(18),
        Email.class, new EmailAnnotationProcessor(),
        Min.class, new MinAnnotationProcessor(),
        Max.class, new MaxAnnotationProcessor()
    );

    public static <T> List<Error> validate(T dto) throws IllegalAccessException {
        List<Error> errors = new ArrayList<>();

        // Get Class object corresponding to dto object
        Class<?> dtoClass = dto.getClass();

        // Get fields of the T class
        Field [] fields = dtoClass.getDeclaredFields();
        for (Field field : fields) {
            // If the field is declared as private change its accessibility in order to read field's value
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }

            errors.addAll(validateField(field, dto));
        }

        return errors;
    }

    private static <T> List<Error> validateField(Field field, T dto) throws IllegalAccessException {
        List<Error> fieldErrors = new ArrayList<>();

        Annotation[] annotations = field.getAnnotations();
        for (Annotation annotation : annotations) {
            String valMessage = null;
            Object fieldValue = field.get(dto);

            Class<? extends Annotation> annotationType = annotation.annotationType();
            AnnotationProcessor annotationProcessor = annotationProcessorMap.get(annotationType);
            if (annotationProcessor != null) {
                valMessage = annotationProcessor.validate(annotation, fieldValue);
            }

            if (valMessage != null) {
                fieldErrors.add(new Error(field.getName(), fieldValue.toString(), valMessage));
            }

        }

        return fieldErrors;
    }
}
