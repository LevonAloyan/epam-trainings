package com.epam.javatrainings.validation;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class AdulthoodAnnotationProcessor extends AnnotationProcessor {

    @Override
    String validate(Field field, Object obj) {
        String msg = "";

        if(!(obj instanceof LocalDate)) {
            throw new IllegalArgumentException(obj + " is not LocalDate type to be validated for the Adulthood field");
        }
        LocalDate objDate = (LocalDate) obj;
        LocalDate currentDate = LocalDate.now();

        if((currentDate.getYear() - objDate.getYear()) < 18) {
            msg += "Not valid! Under the age 18";
        }

        return msg;
    }
}
