package com.epam.javatrainings.annotation;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrors {

   public List validateErrorList(CustomerDto instance) {

        ArrayList<String> errorList = new ArrayList<>();

       if (!new LengthAnnotationProcessor().lengthValidate(instance)) {
           errorList.add("Length Validation error");
       }
        if (!new EmailAnnotationProcessor().emailValidate(instance)) {
            errorList.add("Email Validation error");
        }
        if (!new AdulthoodAnnotationProcessor().adulthoodValidate(instance)) {
            errorList.add("Adulthood Validation error");
        }
        if (!new MaxAnnotationProcessor().maxValidate(instance)) {
            errorList.add("Max Validation error");
        }
        if (!new MinAnnotationProcessor().minValidate(instance)) {
            errorList.add("Min Validation error");
        }
        return errorList;
    }

}
