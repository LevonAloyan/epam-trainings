package com.epam.javatrainings.pizza;

public enum Type {
    REGULAR(1.0),
    CALZONE(1.5);

    private final double basePrice;

    Type(final double basePrice) {
        this.basePrice = basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
