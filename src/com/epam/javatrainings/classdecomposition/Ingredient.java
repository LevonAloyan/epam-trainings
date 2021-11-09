package com.epam.javatrainings.classdecomposition;

public enum Ingredient {
    TomatoPaste(1.0), Cheese(1.0), Salami(1.5),
    Bacon(1.2), Garlic( 0.3), Corn(0.7),
    Pepperoni(0.6), Olives(0.5);

    private double price;

    Ingredient(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
