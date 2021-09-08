package com.epam.javatrainings.annotations;


import java.lang.reflect.Field;

public class LengthValidator {

    private Object object;

    public static void validate(Field f,Object obj) {
        f.setAccessible(true);
        if(!f.isAnnotationPresent(Length.class))
            throw new RuntimeException("No such Annotation");
        try {
            if(f.get(obj) instanceof String)
            {
                String value=(String) f.get(obj);
                if(value.length()<f.getAnnotation(Length.class).min())
                    System.out.println("Too short name");
                else if(value.length()>f.getAnnotation(Length.class).max())
                    System.out.println("Too long name");
            }
            else
                throw new RuntimeException("Not String");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
