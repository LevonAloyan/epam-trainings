package com.epam.javatrainings.annotation.annotation_processors;

import com.epam.javatrainings.annotation.custom_annotations.Max;

public class MaxAnnotationProcessor {
    public static boolean isMaxValid(Max max, int discountRate){
        return discountRate <= max.value();
    }
}
