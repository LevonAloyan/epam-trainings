package com.epam.javatrainings.annotation;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DTOValidatorImpl implements DTOValidator{

    private static String message;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    @Override
    public <T> void validate(T t) {
        message = "Validation " + t.getClass().getName() + "instance:";
        Class clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields){

            if (field.isAnnotationPresent(Length.class)){
                field.setAccessible(true);
                lengthProcessor(field,t);
            }
            if (field.isAnnotationPresent(Email.class)){
                field.setAccessible(true);
                emailProcessor(field,t);
            }
            if (field.isAnnotationPresent(Adulthood.class)){
                field.setAccessible(true);
                adulthoodProcessor(field,t);
            }
            if (field.isAnnotationPresent(Min.class)){
                field.setAccessible(true);
                minProcessor(field,t);
            }
            if (field.isAnnotationPresent(Max.class)){
                field.setAccessible(true);
                maxProcessor(field,t);
            }
        }

        System.out.println(message);
    }

    private <T> void maxProcessor(Field field, T t) {
        try{
            Object value = field.get(t);
            Max max = (Max) field.getAnnotation(Max.class);
            int maxLimit = max.value();
            if (value instanceof Integer){
                maxLimitation((int)value,maxLimit);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void maxLimitation(int value, int maxLimit) {
        if (value > maxLimit){
            message += "\nThe " + value + " is greater than max limit(" + maxLimit + ")";

        }
    }

    private <T> void minProcessor(Field field, T t) {
        try {
            Object value = field.get(t);
            Min min = (Min) field.getAnnotation(Min.class);
            int minLimit = min.value();
            if (value instanceof Integer){
                minLimitation((int) value,minLimit);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void minLimitation(int value,int minLimit) {
        if (value < minLimit){
            message += "\nThe " + value + " is less than min limit(" + minLimit + ")";
        }
    }

    private <T> void adulthoodProcessor(Field field, T t) {
        try {
            Object value = field.get(t);
            Adulthood adulthood = (Adulthood) field.getAnnotation(Adulthood.class);
            if (value instanceof LocalDate){
                validateAdulthood((LocalDate) value);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void validateAdulthood(LocalDate value) {
        if (LocalDate.now().compareTo(value) >= 18){
            message += "\nIs adult";
        }else{
            message += "\nIsn't adult";
        }
    }

    private <T> void emailProcessor(Field field, T t) {
        try {
            Object value = field.get(t);
            Email email = (Email) field.getAnnotation(Length.class);
            if (value instanceof String){
                validateEmail((String) value);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private void validateEmail(String value) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(value);
        if (matcher.find()){
            message += "\nThe email is valid";
        }else {
            message += "\nThe email is invalid";
        }
    }

    private <T> void lengthProcessor(Field field,T t){
        
        try {
            Object value = field.get(t);
            Length length = (Length) field.getAnnotation(Length.class);
            int min = length.min();
            int max = length.max();
            if (value instanceof String){
                validateName((String) value,min,max);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        
    }

    private void validateName(String value, int min, int max) {
        if (value.length() < min){
          message += "\nThe name length less than " + min;
        } else if (value.length() > max){
            message += "\nThe name length greater than " + max;
        }else{
            message += "\nThe name validation succeed";
        }
    }
}
