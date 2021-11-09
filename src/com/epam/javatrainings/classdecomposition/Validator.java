package com.epam.javatrainings.classdecomposition;

public class Validator {
    private Validator() {
        throw new IllegalStateException("No instances");
    }

    public static String validatePizzaName(String name, Order order) {
        if (name.length() < 4 || name.length() > 20) {
            return order.getCustomer().getName() + "_" + order.getOrderNumber();
        }

        return name;
    }
}
