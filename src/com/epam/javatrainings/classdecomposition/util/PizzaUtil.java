package com.epam.javatrainings.classdecomposition.util;

import com.epam.javatrainings.classdecomposition.model.Customer;
import com.epam.javatrainings.classdecomposition.validator.Validator;

/**
 * Created by Hayk on 31.08.2021.
 */
public final class PizzaUtil {
    private static int[] numbers = new int[90000];
    private static int size = 0;

    private PizzaUtil() {
    }

    private static boolean containsNumber(int number, int[] array) {
        for (int i = 0; i < size; i++) {
            if (array[i] == number) {
                return true;
            }
        }
        return false;
    }

    public static int generateOrderNumber() {
        int result;
        int counter = 0;
        do {
            counter++;
            result = 10000 + (int) (Math.random() * 90000);
            if (counter == 90000) {
                break;
            }
        }
        while (containsNumber(result, numbers));
        if (counter == 90000) {
            return -1;
        }
        return result;
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
