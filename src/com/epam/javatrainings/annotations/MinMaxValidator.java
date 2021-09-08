package com.epam.javatrainings.annotations;

import java.lang.reflect.Field;

public class MinMaxValidator {
   public static void validate(Field f,Object obj)
   {
       f.setAccessible(true);
       if(!f.isAnnotationPresent(Min.class)||!f.isAnnotationPresent(Max.class))
           throw new RuntimeException("No such Annotation");
       try {
           int value=(int) f.get(obj);
           if(value<f.getAnnotation(Min.class).value()||f.getAnnotation(Max.class).value()<value)
               System.out.println("Out of Min-Max range");
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       }
   }
}
