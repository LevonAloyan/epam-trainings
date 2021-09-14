package com.epam.javatrainings.annootation_based_DTO.processor;

import com.epam.javatrainings.annootation_based_DTO.persistance.annotation.Max;
import com.epam.javatrainings.annootation_based_DTO.persistance.annotation.Min;
import com.epam.javatrainings.annootation_based_DTO.persistance.model.CustomerDto;

import java.lang.reflect.Field;

public class DiscountRateAnnotationProcessor {
    public static boolean checkValidateDiscountRate(CustomerDto customerDto) throws NoSuchFieldException, IllegalAccessException {
        boolean flag = true;
        Field discountRate = customerDto.getClass().getDeclaredField("discountRate");
        if (discountRate.isAnnotationPresent(Min.class) && discountRate.isAnnotationPresent(Max.class)) {
            discountRate.setAccessible(true);
            Max max = discountRate.getAnnotation(Max.class);
            Min min = discountRate.getAnnotation(Min.class);
            int value = (int) discountRate.get(customerDto);
            flag = check(value,min.value(),max.value());
        }
        return flag;
    }

    private static boolean check(int value, int minValue, int maxValue){
        return !(value < minValue || value > maxValue);
    }
}
