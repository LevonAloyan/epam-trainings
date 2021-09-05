package com.epam.javatrainings.classdecomposition;

public class Pizza {

    private static final String[] pizzaName = {
            "Margarita",
            "Pepperoni",
            "Romana",
            "Calzone 1",
            "Calzone 2",
            "Calzone 3",
    };

    public static String[] getPizzaName() {
        return pizzaName;
    }
}
