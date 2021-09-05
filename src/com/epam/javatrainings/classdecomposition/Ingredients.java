package com.epam.javatrainings.classdecomposition;
enum PizzaType {
    REGULAR(1.0),
    CALZONE(1.5);

    private final double basePrice;

    PizzaType(double p) {
        basePrice = p;
    }

    public double getBasePrice() {
        return basePrice;
    }
}

enum Ingredients {
    TOMATO_PASTE(1.0),
    CHEESE(1.0),
    SALAMI(1.5),
    BACON(1.2),
    GARLIC(0.3),
    CORN(0.7),
    PEPPERONI(0.6),
    OLIVES(0.5);

    private double IngredientsPrice;

    Ingredients(){}

    Ingredients(double p) {
        IngredientsPrice = p;
    }

    public double getIngredientsPrice() {
        return IngredientsPrice;
    }
}
