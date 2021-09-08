package com.epam.javatrainings.annotations;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.reflect.Field;
import java.time.LocalDate;

public class Validator {
    public void validate(Dto obj)
    {
        try {
            Field name=obj.getClass().getDeclaredField("name");
            LengthValidator.validate(name,obj);
            Field email=obj.getClass().getDeclaredField("email");
            EmailValidator.validate(email,obj);
            Field birthday=obj.getClass().getDeclaredField("birthday");
            AdulthoodValidator.validate(birthday,obj);
            Field discount = obj.getClass().getDeclaredField("discount");
            MinMaxValidator.validate(discount,obj);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        LocalDate date=LocalDate.now();
        LocalDate birthday=date.minusYears(18);
        Dto a=new Dto("Amer","arthur@gmail.com",birthday,0);
        Validator v=new Validator();
        v.validate(a);
    }
}
