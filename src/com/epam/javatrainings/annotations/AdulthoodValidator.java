package com.epam.javatrainings.annotations;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class AdulthoodValidator {
    static public  void validate(Field f,Object obj)
    {
        f.setAccessible(true);
        if(!f.isAnnotationPresent(Adulthood.class))
            throw new RuntimeException("No such annotation");
        try {
            LocalDate date=(LocalDate) f.get(obj);

            LocalDate date_to_compare =LocalDate.now().minusYears(18);
            if(date.isAfter(date_to_compare))
                System.out.println("Customer is not adult");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
