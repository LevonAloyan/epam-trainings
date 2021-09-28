package com.epam.javatrainings.annootation_based_DTO.service;

import com.epam.javatrainings.annootation_based_DTO.exception.CustomerAgeException;
import com.epam.javatrainings.annootation_based_DTO.exception.CustomerDiscountRateException;
import com.epam.javatrainings.annootation_based_DTO.exception.CustomerEmailAddressException;
import com.epam.javatrainings.annootation_based_DTO.exception.CustomerNameLengthException;
import com.epam.javatrainings.annootation_based_DTO.processor.AdulthoodAnnotationProcessor;
import com.epam.javatrainings.annootation_based_DTO.processor.DiscountRateAnnotationProcessor;
import com.epam.javatrainings.annootation_based_DTO.processor.EmailAnnotationProcessor;
import com.epam.javatrainings.annootation_based_DTO.processor.LengthAnnotationProcessor;

import java.util.ArrayList;
import java.util.List;

public class ValidatorService {
    public static<T> List<RuntimeException> validate(T t) throws NoSuchFieldException, IllegalAccessException {
        List<RuntimeException> validationFailedList = new ArrayList<>();

        if (!LengthAnnotationProcessor.checkValidateLength(t)){
            validationFailedList.add(new CustomerNameLengthException("\"Invalid length: Customer name length could not be \"less than 2 and more than 30 characters\""));
        }
        if (!EmailAnnotationProcessor.checkValidateEmail(t)){
            validationFailedList.add(new CustomerEmailAddressException("Invalid email: Customer email should be in this form \"somethingText@gmail or mail.com or ru\""));
        }

        if (!AdulthoodAnnotationProcessor.checkValidateBirthDay(t)){
            validationFailedList.add(new CustomerAgeException("Invalid birth day: Customer birth day should be in this form \"yyyy/m/d\""));
        }

        if (!DiscountRateAnnotationProcessor.checkValidateDiscountRate(t)){
            validationFailedList.add(new CustomerDiscountRateException("Invalid discount rate: Customer discount rate could not be \"less than 0 and more than 100 characters\""));
        }
        return validationFailedList;
    }

    public static<T> void printAllExceptions(T t) throws NoSuchFieldException, IllegalAccessException {
        for (RuntimeException validationFailed : validate(t)) {
            validationFailed.printStackTrace();
        }
    }
}
