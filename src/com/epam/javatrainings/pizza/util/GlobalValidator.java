package com.epam.javatrainings.pizza.util;

import com.epam.javatrainings.pizza.dto.Dto;
import com.epam.javatrainings.pizza.util.validators.*;

import java.util.ArrayList;
import java.util.List;

public class GlobalValidator {

    private static final  List<String> ERROR_MESSAGES = new ArrayList<>();

    private GlobalValidator() {
    }

    public static void validate(Dto dto) {

        boolean isValidEmail = EmailValidator.validateEmail(dto, ERROR_MESSAGES);
        boolean isValidLength = LengthValidator.validateLength(dto, ERROR_MESSAGES);
        boolean isValidAge = AdulthoodValidator.validateAdulthood(dto, ERROR_MESSAGES);
        boolean isValidDiscountRate = MaxValidator.validateMax(dto, ERROR_MESSAGES) && MinValidator.validateMin(dto, ERROR_MESSAGES);

        if(!isValidEmail) {
            throw new IllegalArgumentException("Invalid Email address");
        }
        if(!isValidLength) {
            throw new IllegalArgumentException("Invalid length of name");
        }
        if(!isValidAge) {
            throw new IllegalArgumentException("Age of User must be grater than 18");
        }
        if(!isValidDiscountRate) {
            throw new IllegalArgumentException("Invalid discount rate, must be in 0-100");
        }
    }

    public static List<String> getErrorMessages() {
        return ERROR_MESSAGES;
    }
}
