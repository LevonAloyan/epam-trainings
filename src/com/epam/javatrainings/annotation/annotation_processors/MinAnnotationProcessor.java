package com.epam.javatrainings.annotation.annotation_processors;

import com.epam.javatrainings.annotation.custom_annotations.Min;

public class MinAnnotationProcessor {
    public  static boolean isMinValid(Min discountRate, int value){
        return value >= discountRate.value();
    }
}
