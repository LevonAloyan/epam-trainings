package com.epam.javatrainings;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.*;
import java.time.Period;

public class Validator <T> {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =  Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private ArrayList<Error> errorList;
    private T dto;

    public Validator(T dto){
        this.dto = dto;
        errorList = new ArrayList<Error>();
    }

    public ArrayList <Error> Validate() {
        try {
            Class cls = dto.getClass();
            Field nameField = cls.getDeclaredField("name");
            Length nameAnnotation = nameField.getAnnotation(Length.class);
            Method getName = cls.getMethod("getName");
            String name = (String) getName.invoke(dto);
            if (name.length() < nameAnnotation.min()) {
                errorList.add(new Error("The length of " + nameField.getName() + " must be at least " + nameAnnotation.min() + '.'));
            }
            if (name.length() > nameAnnotation.max()) {
                errorList.add(new Error("The length of " + nameField.getName() + " must be at most " + nameAnnotation.max() + '.'));
            }

            Field emailField = cls.getDeclaredField("email");
            if (emailField.isAnnotationPresent(Email.class)) {
                Method getEmail = cls.getMethod("getEmail");
                String email = (String)getEmail.invoke(dto);
                Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
                 if(!matcher.find()){
                     errorList.add(new Error("Invalid email."));
                 }
            }

            Field birthDateField = cls.getDeclaredField("birthDate");

            if (birthDateField.isAnnotationPresent(Adulthood.class)) {
                Method getBirthDate = cls.getMethod("getBirthDate");
                LocalDate birthDate = (LocalDate)getBirthDate.invoke(dto);
                LocalDate dateNow = LocalDate.now();
                if(Period.between(birthDate, dateNow).getYears() < 18){
                    errorList.add(new Error("Isn't adult."));
                }
            }

            Field discountRateField = cls.getDeclaredField("discountRate");
            Min minAnnotation = discountRateField.getAnnotation(Min.class);
            Max maxAnnotation = discountRateField.getAnnotation(Max.class);
            Method getDiscountRate = cls.getMethod("getDiscountRate");
            int discountRate = (int) getDiscountRate.invoke(dto);
            if (discountRate < minAnnotation.value()) {
                errorList.add(new Error("The discountRate must be above " + minAnnotation.value() + '.' ));
            }
            if (discountRate > maxAnnotation.value()) {
                errorList.add(new Error("The discountRate must be less than " + maxAnnotation.value() + '.' ));
            }


            return errorList;
        }
        catch (Exception ex){
            System.out.println("Not found");
        }

        return errorList;
    }
}
