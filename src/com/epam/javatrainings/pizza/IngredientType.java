package com.epam.javatrainings.pizza;

import java.util.Arrays;

public enum IngredientType {

    TOMATO_PASTE(1.0),
    CHEESE(1.0),
    SALAMI(1.5),
    BACON(1.2),
    GARLIC(0.3),
    CORN(0.7),
    PEPPERONI(0.6),
    OLIVES(0.5);

    private final double price;

    IngredientType(double p) {
        price = p;
    }

    public double getPrice() {
        return price;
    }

    public static IngredientType findByName(String name) {
       return Arrays.stream(values())
                .filter(ingredientType -> ingredientType.name().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Type not found"));
    }
}
