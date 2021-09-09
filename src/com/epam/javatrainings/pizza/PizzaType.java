package com.epam.javatrainings.pizza;

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
