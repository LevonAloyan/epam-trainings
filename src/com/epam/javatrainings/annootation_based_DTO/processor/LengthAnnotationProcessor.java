package com.epam.javatrainings.annootation_based_DTO.processor;

import com.epam.javatrainings.annootation_based_DTO.persistance.annotation.Length;

import java.lang.reflect.Field;

public class LengthAnnotationProcessor {
    public static<T> boolean checkValidateLength(T data) throws NoSuchFieldException, IllegalAccessException {
        boolean flag = true;
        Field name = data.getClass().getDeclaredField("name");
        if (name.isAnnotationPresent(Length.class)) {
            name.setAccessible(true);
            Length nameLength = name.getAnnotation(Length.class);
            String customerName = (String) name.get(data);
            flag = check(customerName,nameLength.min(),nameLength.max());
        }
        return flag;
    }

    private static boolean check(String customerName, int nameMinLength, int nameMaxLength){
        return !(customerName.length() < nameMinLength || customerName.length() > nameMaxLength);
    }
}
