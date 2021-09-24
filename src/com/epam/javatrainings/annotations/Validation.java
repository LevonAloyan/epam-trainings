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


    public static <T> void validate(T t) throws ClassCastException,IllegalAccessException {
        Class clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {

            if (field.isAnnotationPresent(Length.class)) {
                try {
                    new LengthAnnotationProcessor(field, t);
                } catch (InappropriateNameException e) {
                    e.printStackTrace();
                }
            }
            if (field.isAnnotationPresent(Email.class)) {
                try {
                    new EmailAnnotationProcessor(field, t);
                } catch (EmailNotValidException e) {
                    e.printStackTrace();
                }
            }
            if (field.isAnnotationPresent(Adulthood.class)) {
                try {
                    new AdulthoodAnnotationProcessor(field, t);
                } catch (InappropriateAgeException e) {
                    e.printStackTrace();
                }
            }
            if (field.isAnnotationPresent(Min.class) || field.isAnnotationPresent(Max.class)) {
                try {
                    new MaxAndMinAnnotationsProcessor(field,t);
                } catch (WrongDiscountException e) {
                    e.printStackTrace();
                }

            }
        }

    }


}
