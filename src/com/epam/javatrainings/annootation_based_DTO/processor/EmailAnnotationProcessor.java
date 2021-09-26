package com.epam.javatrainings.annootation_based_DTO.processor;

import com.epam.javatrainings.annootation_based_DTO.persistance.annotation.Email;
import com.epam.javatrainings.annootation_based_DTO.persistance.model.CustomerDto;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class EmailAnnotationProcessor {
    public static<T> boolean checkValidateEmail(T data) throws NoSuchFieldException, IllegalAccessException {
        boolean flag = true;
        Field email = data.getClass().getDeclaredField("email");
        if (email.isAnnotationPresent(Email.class)) {
            email.setAccessible(true);
            String emailValue = (String) email.get(data);
            flag = check(emailValue);
        }
        return flag;
    }

    private static boolean emailValidation(String email) {
        Pattern pattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_" +
                "`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[" +
                "\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a" +
                "-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9" +
                "]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[" +
                "\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\" +
                "x0e-\\x7f])+)])");
        return pattern.matcher(email).matches();
    }

    private static boolean check(String email){
        return emailValidation(email);
    }
}
