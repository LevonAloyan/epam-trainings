package com.epam.javatrainings.annotation;

import com.epam.javatrainings.annotation.annotationValidator.processor.AnnotationProcessor;
import com.epam.javatrainings.annotation.dto.CustomerDto;

import java.time.LocalDate;

/**
 * Created by Hayk on 12.09.2021.
 */
public class TestAnnotation {
    public static void main(String[] args) {
        CustomerDto customerDto=new CustomerDto("Hayk6","sardaryanhaykr@gmail.com", LocalDate.of(1985,8,19),13);
        new AnnotationProcessor().doProcess(customerDto);
        System.out.println(customerDto);
    }
}
