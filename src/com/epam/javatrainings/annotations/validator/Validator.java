package com.epam.javatrainings.annotations.validator;

import com.epam.javatrainings.annotations.custom_annotations.*;


import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator<T>{

    Pattern VALID_EMAIL_ADDRESS_REGEX;
    Matcher matcher;
    List<String> errorList = new ArrayList<>();

    public List<String> validate(T dto) throws IllegalAccessException, NoSuchFieldException {
        Field discountRate = dto.getClass().getDeclaredField("discountRate");
        if (discountRate.isAnnotationPresent(Min.class) && discountRate.isAnnotationPresent(Max.class)) {
            discountRate.setAccessible(true);
            Min min = discountRate.getAnnotation(Min.class);
            Max max = discountRate.getAnnotation(Max.class);
            if ((int) discountRate.get(dto) < min.min() || max.max() < (int) discountRate.get(dto)) {
                errorList.add("Discount value is wrong!!");
            }
        }
        Field name = dto.getClass().getDeclaredField("name");
        if (name.isAnnotationPresent(Length.class)) {
            name.setAccessible(true);
            Length length = name.getAnnotation(Length.class);
            if (((String) name.get(dto)).length() < length.min() || ((String) name.get(dto)).length() > length.max()) {
                errorList.add("Wrong length for name!!");
            }
        }

        Field email = dto.getClass().getDeclaredField("email");
        if (email.isAnnotationPresent(Email.class)) {
            email.setAccessible(true);
            VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
            matcher = VALID_EMAIL_ADDRESS_REGEX.matcher((String) email.get(dto));
            boolean isValidEmail = matcher.find();
            if (!isValidEmail) {
                errorList.add("Wrong email format!!");
            }
        }

        Field birthday = dto.getClass().getDeclaredField("birthday");
        if (birthday.isAnnotationPresent(Adulthood.class)) {
            birthday.setAccessible(true);
            LocalDate today = LocalDate.now();
            if (Period.between((LocalDate) birthday.get(dto), today).getYears() < 18) {
                errorList.add("Age is less then 18 !!");
            }
        }
        return errorList;
    }
}
