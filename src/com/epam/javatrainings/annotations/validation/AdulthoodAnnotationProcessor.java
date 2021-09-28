package com.epam.javatrainings.annotations.validation;

import java.lang.annotation.Annotation;
import java.time.LocalDate;
import java.time.Period;

public class AdulthoodAnnotationProcessor extends AnnotationProcessor {
    private int ageOfMajorityBound;

    AdulthoodAnnotationProcessor(int ageOfMajorityBound) {
        this.ageOfMajorityBound = ageOfMajorityBound;
    }

    @Override
    String validate(Annotation annotation, Object value) {
        if (!(value instanceof LocalDate)) {
            throw new IllegalStateException();
        }

        Period period = Period.between((LocalDate) value, LocalDate.now());
        int age = period.getYears();

        if (age < this.ageOfMajorityBound) {
            return "The client has not reached the age of majority. The age is "  + age + " years.";
        }

        return null;
    }
}
