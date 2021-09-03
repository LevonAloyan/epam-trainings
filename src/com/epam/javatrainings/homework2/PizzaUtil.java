package com.epam.javatrainings.homework2;

import com.epam.javatrainings.homework2.model.Customer;

public class PizzaUtil {
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
