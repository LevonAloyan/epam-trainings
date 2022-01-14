package com.epam.javatrainings.classdecomposition.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Hayk on 31.08.2021.
 */
public final class Validator {

    private final static String regularExpressionDouble = "-?[0-9]+(?:[,.][0-9]+)?";
    private final static String regularExpressionInt = "-?[1-9]\\d*|0";
    private static final Pattern DOUBLE_PATTERN = Pattern.compile(regularExpressionDouble);
    private static final Pattern INT_PATTERN = Pattern.compile(regularExpressionInt);
    private final static String regularExpressionEmail = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    private final static Pattern EMAIL_PATTERN = Pattern.compile(regularExpressionEmail, Pattern.CASE_INSENSITIVE);

    private Validator() {
    }

    public static boolean isEmail(String expression) {
        Matcher matcher = EMAIL_PATTERN.matcher(expression);
        return matcher.matches();
    }

    public static boolean isInt(String expression) {
        Matcher matcher = INT_PATTERN.matcher(expression);
        return matcher.matches();
    }

    public static boolean isDouble(String expression) {
        Matcher matcher = DOUBLE_PATTERN.matcher(expression);
        return matcher.matches();
    }

    public static boolean isValidNumber(String param) {
        try {
            return Integer.parseInt(param) >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidInteger(String param) {
        try {
            return Integer.getInteger(param) instanceof Integer;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidName(String name) {
        if (name.length() < 4 || name.length() > 20) {
            return false;
        }
        return true;
    }
}
