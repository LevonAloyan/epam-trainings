package com.epam.javatrainings.homework2.model;

public enum PizzaType {
    REGULAR(0),
    CALZONE(0.5);
    private double priceOfType;

    PizzaType(double priceOfType) {
        this.priceOfType = priceOfType;
    }

    public double getPriceOfType() {
        return this.priceOfType;
    }

}
