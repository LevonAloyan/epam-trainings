package com.epam.javatrainings.genericannotations.util;

import com.epam.javatrainings.genericannotations.util.validators.*;

import java.util.ArrayList;
import java.util.List;

public class GlobalValidator<T> {

    private static boolean isValidEmail;
    private static boolean isValidLength;
    private static boolean isValidAge;
    private static boolean isValidDiscountRate;

    private GlobalValidator() {
    }

    public static <T> List<String> validate(T t) {
        List<String> ERROR_MESSAGES = new ArrayList<>();
        isValidEmail = EmailValidator.validateEmail(t, ERROR_MESSAGES);
        isValidLength = LengthValidator.validateLength(t, ERROR_MESSAGES);
        isValidAge = AdulthoodValidator.validateAdulthood(t, ERROR_MESSAGES);
        isValidDiscountRate = MaxValidator.validateMax(t, ERROR_MESSAGES) && MinValidator.validateMin(t, ERROR_MESSAGES);
        return ERROR_MESSAGES;
    }

    public static boolean isIsValidEmail() {
        return isValidEmail;
    }

    public static boolean isIsValidLength() {
        return isValidLength;
    }

    public static boolean isIsValidAge() {
        return isValidAge;
    }

    public static boolean isIsValidDiscountRate() {
        return isValidDiscountRate;
    }
}
