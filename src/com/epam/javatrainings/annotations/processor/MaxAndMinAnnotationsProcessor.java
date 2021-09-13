package com.epam.javatrainings.annotations.processor;

import com.epam.javatrainings.annotations.annotation.Max;
import com.epam.javatrainings.annotations.annotation.Min;
import com.epam.javatrainings.annotations.exception.WrongDiscountException;

import java.lang.reflect.Field;

public class MaxAndMinAnnotationsProcessor {
    public <T> MaxAndMinAnnotationsProcessor(Field field, T t) throws WrongDiscountException, IllegalAccessException {
        field.setAccessible(true);
        Min min = field.getAnnotation(Min.class);
        Max max = field.getAnnotation(Max.class);
        Integer discountRate = (Integer) field.get(t);
        if (discountRate < min.min() || discountRate > max.max()) {
            throw new WrongDiscountException("Such a discount is not possible , :( ");
        }
    }
}
