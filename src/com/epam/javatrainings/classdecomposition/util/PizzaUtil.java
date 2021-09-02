package com.epam.javatrainings.classdecomposition.util;

import com.epam.javatrainings.classdecomposition.model.Customer;
import com.epam.javatrainings.classdecomposition.validator.Validator;

/**
 * Created by Hayk on 31.08.2021.
 */
public final class PizzaUtil {
    private PizzaUtil() {
    }

    public static String generateName(String name, Customer customer, int id) {
        String result;
        if (Validator.isValidName(name)) {
            result = name;
        } else {
            result = customer.getName() + "_" + id;
        }
        result = result.toLowerCase();
        return result.substring(0, 1).toUpperCase() + result.substring(1);
    }
}
