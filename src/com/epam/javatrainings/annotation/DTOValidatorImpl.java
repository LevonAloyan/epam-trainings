package com.epam.javatrainings.annotation;

import com.epam.javatrainings.annotation.processors.*;

import java.util.ArrayList;
import java.util.List;

public class DTOValidatorImpl implements DTOValidator{

    private static final List<Error> errors = new ArrayList<>();



    @Override
    public <T> void validate(T t) {

        errors.addAll(LengthProcessor.validateLength(t));
        errors.addAll(EmailProcessor.validateEmail(t));
        errors.addAll(AdulthoodProcessor.validate(t));
        errors.addAll(MaxProcessor.validate(t));
        errors.addAll(MinProcessor.validate(t));

        if (!errors.isEmpty()){
            for (Error error : errors){
                System.out.println(error);
            }
        }else {
            System.out.println("Validation passed");
        }
    }










}
