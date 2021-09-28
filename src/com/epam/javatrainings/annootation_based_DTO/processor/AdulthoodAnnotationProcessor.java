package com.epam.javatrainings.annootation_based_DTO.processor;

import com.epam.javatrainings.annootation_based_DTO.persistance.annotation.Adulthood;
import com.epam.javatrainings.annootation_based_DTO.persistance.model.CustomerDto;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class AdulthoodAnnotationProcessor {
    public static<T> boolean checkValidateBirthDay(T data) throws NoSuchFieldException, IllegalAccessException {
        boolean flag = true;
        Field birthDay = data.getClass().getDeclaredField("birthDay");
        if (birthDay.isAnnotationPresent(Adulthood.class)) {
            birthDay.setAccessible(true);
            LocalDate birthDayValue = (LocalDate) birthDay.get(data);
            flag = check(birthDayValue.getYear());
        }
        return flag;
    }

    private static int getThisYear() {
        return LocalDate.now().getYear();
    }

    private static boolean check(int birthDayValueYear){
        return (getThisYear() - birthDayValueYear) >= 18;
    }
}
