package com.epam.javatrainings.pizza;

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

    Ingredients() {
    }

    Ingredients(double p) {
        IngredientsPrice = p;
    }

    public double getIngredientsPrice() {
        return IngredientsPrice;
    }
}
