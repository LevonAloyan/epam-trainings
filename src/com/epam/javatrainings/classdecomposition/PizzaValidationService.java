package com.epam.javatrainings.classdecomposition;

import java.util.Locale;

public final class PizzaValidationService {

    private PizzaValidationService(){}


    /**
     * name must contain at least 4 and no more than 20 Latin characters
     *
     * @param name
     * @return
     */
    public static boolean isValidName(String name) {
        boolean validName = false;
        if (name != null && name.length() >= 4 && name.length() <= 20) {
            validName = isLatin(name);
        }

        return validName;
    }

    /**
     * name must contain only Latin characters
     *
     * @param name
     * @return
     */
    private static boolean isLatin(String name) {
        boolean validName = true;
        char[] nameArray = name.toLowerCase(Locale.ROOT).toCharArray();
        for (char ch : nameArray) {
            if (ch < 97 || ch > 122) {
                validName = false;
                break;
            }
        }
        return validName;
    }
}
