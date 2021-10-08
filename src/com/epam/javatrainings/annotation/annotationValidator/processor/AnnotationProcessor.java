package com.epam.javatrainings.annotation.annotationValidator.processor;

import com.epam.javatrainings.annotation.annotationValidator.*;
import com.epam.javatrainings.annotation.dto.CustomerDto;

/**
 * Created by Hayk on 12.09.2021.
 */
public final class AnnotationProcessor {
    public AnnotationProcessor(){}

   public void doProcess(CustomerDto customer){
        new AdulthoodValidator().check(customer);
        new EmailValidator().check(customer);
        new LengthValidator().check(customer);
        new MaxValidator().check(customer);
        new MinValidator().check(customer);
    }
}
