package com.epam.javatrainings.annootation_based_DTO.processor;

import com.epam.javatrainings.annootation_based_DTO.persistance.annotation.Length;
import com.epam.javatrainings.annootation_based_DTO.persistance.model.CustomerDto;

import java.lang.reflect.Field;

public class LengthAnnotationProcessor {
    public static boolean checkValidateLength(CustomerDto customerDto) throws NoSuchFieldException, IllegalAccessException {
        boolean flag = true;
        Field name = customerDto.getClass().getDeclaredField("name");
        if (name.isAnnotationPresent(Length.class)) {
            name.setAccessible(true);
            Length nameLength = name.getAnnotation(Length.class);
            String customerName = (String) name.get(customerDto);
            flag = check(customerName,nameLength.min(),nameLength.max());
        }
        return flag;
    }

    private static boolean check(String customerName, int nameMinLength, int nameMaxLength){
        return !(customerName.length() < nameMinLength || customerName.length() > nameMaxLength);
    }
}
