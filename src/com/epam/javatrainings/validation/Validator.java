package com.epam.javatrainings.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static List<Error> validate(CustomerDto dto) throws IllegalAccessException {
        List<Error> listOfErrors = new ArrayList<>();

        Class<? extends CustomerDto> dtoClass = dto.getClass();

        Field[] declaredFields = dtoClass.getDeclaredFields();

        for(Field df : declaredFields) {
            Annotation[] annotations = df.getAnnotations();
            df.setAccessible(true);
            for(Annotation a : annotations) {
                AnnotationProcessor ap = ValidatorUtils.detectAnnotationProcessor(a);
                String errorMsg = ap.validate(df, df.get(dto));
                if(!errorMsg.equals("")) {                               //if there is an error message
                    listOfErrors.add(new Error(errorMsg));
                }
            }
        }

        return listOfErrors;
    }
}
