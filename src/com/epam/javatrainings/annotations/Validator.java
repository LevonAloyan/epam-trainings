package com.epam.javatrainings.annotations;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;

public class Validator {
    @Retention(RetentionPolicy.RUNTIME)
    @interface Length{
        int min();
        int max();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface Email{
    }
    @Retention(RetentionPolicy.RUNTIME)
    @interface Adulthood{
    }
    @Retention(RetentionPolicy.RUNTIME)
    @interface Min{
        int value();
    }
    @Retention(RetentionPolicy.RUNTIME)
    @interface Max{
        int value();
    }
    public void validate(CustomerDto dto)
    {
        try{
            Field name=dto.getClass().getField("name");
            Length length=name.getAnnotation(Length.class);
            if(length.max()<dto.getName().length())
                System.out.println("Too long name");
            else if(length.min()>dto.getName().length())
                System.out.println("Too short Name");
            Field email =dto.getClass().getField("email");
            Email valid=email.getAnnotation(Email.class);
            if(!dto.getEmail().matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"))
                System.out.println("Email invalid");
            Field birthday=dto.getClass().getField("birthday");
            Adulthood isAdult=birthday.getAnnotation(Adulthood.class);
            if(LocalDate.now().minusYears(18).isBefore(dto.getBirthday()))
                System.out.println("Customer is not adult");
            Field discount=dto.getClass().getField("discount");
            Min min=discount.getAnnotation(Min.class);
            Max max=discount.getAnnotation(Max.class);
            if(dto.getDiscount()<min.value()||max.value()<dto.getDiscount())
                System.out.println("Discount mismatch");
        }catch (NoSuchFieldException ex){
            System.out.println("field error");
        }
        catch (AnnotationTypeMismatchException aex)
        {
            System.out.println("Annotation mismatch");
        }
    }
}
