package com.epam.javatrainings.classdecomposition.model;

/**
 * Created by Hayk on 31.08.2021.
 */
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
