package com.epam.javatrainings.classdecomposition.palmetto.enums;

public enum Ingredient {

    BACON(1.2), CHEESE(1), CORN(0.7), GARLIC(0.3), OLIVES(0.5), PEPPERONI(0.6), SALAMI(1.5), TOMATO_PASTE(1);

    private final double rate;

    Ingredient(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
