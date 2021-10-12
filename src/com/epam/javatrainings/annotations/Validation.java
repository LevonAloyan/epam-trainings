package com.epam.javatrainings.annotations;

import com.epam.javatrainings.annotations.annotation.*;
import com.epam.javatrainings.annotations.exception.EmailNotValidException;
import com.epam.javatrainings.annotations.exception.InappropriateAgeException;
import com.epam.javatrainings.annotations.exception.InappropriateNameException;
import com.epam.javatrainings.annotations.exception.WrongDiscountException;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    Pattern p = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b");

    public static <T> boolean validate(T t) throws IllegalAccessException, InappropriateNameException, EmailNotValidException, InappropriateAgeException, WrongDiscountException {
        Class clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {

            if (field.isAnnotationPresent(Length.class)) {
                field.setAccessible(true);
                String name = (String) field.get(t);
                int nameFieldLen = name.length();
                Length length = field.getAnnotation(Length.class);
                if (nameFieldLen < length.min() || nameFieldLen > length.max()) {
                    throw new InappropriateNameException("Inappropriate Name , please try again :)");
                }
            }
            if (field.isAnnotationPresent(Email.class)) {
                field.setAccessible(true);
                String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher((String) field.get(t)) ;

                if (!matcher.matches()) {
                    throw new EmailNotValidException("Email is not valid, please try again :)");
                }

            }
            if (field.isAnnotationPresent(Adulthood.class)) {
                field.setAccessible(true);
                LocalDate localDate = (LocalDate) field.get(t);
                int birthYear = localDate.getYear();
                int currentYear = LocalDate.now().getYear();
                if (currentYear - birthYear < 18) {
                    throw new InappropriateAgeException("Your age is Inappropriate , : please try few years later :)");
                }
            }
            if (field.isAnnotationPresent(Min.class) && field.isAnnotationPresent(Max.class)) {
                field.setAccessible(true);
                Min min = field.getAnnotation(Min.class);
                Max max = field.getAnnotation(Max.class);
                Integer discountRate = (Integer) field.get(t);
                if (discountRate < min.min() || discountRate > max.max()) {
                    throw new WrongDiscountException("Such a discount is not possible , :( ");
                }
            }
        }
        return true;
    }
}
