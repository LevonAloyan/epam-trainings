package com.epam.javatrainings.validation;

import java.lang.annotation.Annotation;
import java.util.List;

public class ValidatorUtils {

    public static AnnotationProcessor detectAnnotationProcessor(Annotation annotation) {
        if(annotation instanceof Length) {
            return new LengthAnnotationProcessor();
        } else if(annotation instanceof Email) {
            return new EmailAnnotationProcessor();
        } else if(annotation instanceof Adulthood) {
            return new AdulthoodAnnotationProcessor();
        } else if(annotation instanceof Min) {
            return new MinAnnotationProcessor();
        } else {
            return new MaxAnnotationProcessor();
        }
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
