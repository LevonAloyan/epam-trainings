package com.epam.javatrainings.classdecomposition.model;

/**
 * Created by Hayk on 31.08.2021.
 */
public enum Ingredient {
    TOMATO_PASTE(1),
    CHEESE(1),
    SALAMI(1.5),
    BACON(1.2),
    GARLIC(0.3),
    CORN(0.7),
    PEPPERONI(0.6),
    OLIVES(0.5);
    private final double price;

    Ingredient(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
