package com.epam.javatrainings.annotations.processor;

import com.epam.javatrainings.annotations.annotation.Email;
import com.epam.javatrainings.annotations.exception.EmailNotValidException;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAnnotationProcessor {

    public static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    Pattern p = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b");

    public <T> EmailAnnotationProcessor(Field field, T t) throws EmailNotValidException, IllegalAccessException {
        field.setAccessible(true);

        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((String) field.get(t)) ;

        if (!matcher.matches()) {
            throw new EmailNotValidException("Email is not valid, please try again :)");
        }
    }
}
