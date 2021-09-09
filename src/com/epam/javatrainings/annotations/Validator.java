package com.epam.javatrainings.annotations;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class Validator {

    public void validate1(CustomerDto instance) {
        try {
            Field length = instance.getClass().getDeclaredField("name");
            if (length.isAnnotationPresent(Length.class)) {
                length.setAccessible(true);
                String name = (String) length.get(instance);
                int fieldlength = name.length();
                Length length1 = length.getAnnotation(Length.class);
                if (fieldlength > length1.min() && fieldlength < length1.max()) {
                    System.out.println("You entered wrong length please fix it");
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void validate2(CustomerDto instance) {
        try {
            Field email = instance.getClass().getDeclaredField("email");
            if (email.isAnnotationPresent(Email.class)) {
                email.setAccessible(true);
                String email1 = (String) email.get(instance);
//                Pattern p = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b");
//                Matcher matcher=p.matcher(email1);
//                if(!matcher.find()){
//                    System.out.println("error");
//                }
                String regex = "^(.+)@(.+)$";
                if (!email1.matches(regex)) {
                    System.out.println("You entered wrong email address");
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void validate3(CustomerDto instance) {
        try {
            Field birthDay = instance.getClass().getDeclaredField("birthDay");
            if (birthDay.isAnnotationPresent(Adulthood.class)) {
                birthDay.setAccessible(true);
                LocalDate localDate = (LocalDate) birthDay.get(instance);
                int birthDay1 = localDate.getYear();
                int currentYear = LocalDate.now().getYear();

                if (currentYear - birthDay1 < 18) {
                    System.out.println("You are a minor");
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void validate4(CustomerDto instance) throws NoSuchFieldException, IllegalAccessException {
        Field minmaxfield = instance.getClass().getDeclaredField("discountRate");
        Field max = instance.getClass().getDeclaredField("discountRate");
        if (minmaxfield.isAnnotationPresent(Min.class) && max.isAnnotationPresent(Max.class)) {
            minmaxfield.setAccessible(true);
            max.setAccessible(true);
            Min min2=minmaxfield.getAnnotation(Min.class);
            Max max2=max.getAnnotation(Max.class);
            int minfield= (int) minmaxfield.get(instance);
            if(minfield>min2.value() && minfield<max2.value()){
                System.out.println("You are right");
            }

        }
    }
}
