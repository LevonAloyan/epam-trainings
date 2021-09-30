package com.epam.javatrainings.validation;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public class ValidatorUtils {

    private static Map<Class<? extends Annotation>, ? extends AnnotationProcessor> annotationProcessorsMap = Map.of(
            Length.class, new LengthAnnotationProcessor(),
            Adulthood.class, new AdulthoodAnnotationProcessor(),
            Email.class, new EmailAnnotationProcessor(),
            Max.class, new MaxAnnotationProcessor(),
            Min.class, new MinAnnotationProcessor()
    );

    public static <T extends Annotation>  AnnotationProcessor detectAnnotationProcessor(Annotation annotation) {
        Class<? extends Annotation> annotationType = annotation.annotationType();
        AnnotationProcessor annotationProcessor = annotationProcessorsMap.get(annotationType);
        if(annotationProcessor == null) {
            throw new IllegalArgumentException("Unknown Annotation type");
        }
        return annotationProcessor;
    }

    public static void printErrorMessages(List<Error> errors) {
        if(errors.isEmpty()) {
            System.out.println("Valid DTO!");
        } else {
            for(Error e : errors) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
    }
}
