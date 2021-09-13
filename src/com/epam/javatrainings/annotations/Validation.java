package com.epam.javatrainings.annotations;

import com.epam.javatrainings.annotations.annotation.*;
import com.epam.javatrainings.annotations.exception.EmailNotValidException;
import com.epam.javatrainings.annotations.exception.InappropriateAgeException;
import com.epam.javatrainings.annotations.exception.InappropriateNameException;
import com.epam.javatrainings.annotations.exception.WrongDiscountException;
import com.epam.javatrainings.annotations.processor.AdulthoodAnnotationProcessor;
import com.epam.javatrainings.annotations.processor.EmailAnnotationProcessor;
import com.epam.javatrainings.annotations.processor.LengthAnnotationProcessor;
import com.epam.javatrainings.annotations.processor.MaxAndMinAnnotationsProcessor;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    Pattern p = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b");

    public static <T> void validate(T t) throws IllegalAccessException, InappropriateNameException, EmailNotValidException, InappropriateAgeException, WrongDiscountException {
        Class clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {

            if (field.isAnnotationPresent(Length.class)) {
              new LengthAnnotationProcessor(field, t);
            }
            if (field.isAnnotationPresent(Email.class)) {
              new EmailAnnotationProcessor(field, t);
            }
            if (field.isAnnotationPresent(Adulthood.class)) {
               new AdulthoodAnnotationProcessor(field, t);
            }
            if (field.isAnnotationPresent(Min.class) && field.isAnnotationPresent(Max.class)) {
              new MaxAndMinAnnotationsProcessor(field,t);
            }
        }

    }


}
