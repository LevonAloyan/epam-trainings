package com.epam.javatrainings.classdecomposition.pizza;

import java.math.BigDecimal;

public enum PizzaType {
    REGULAR("Pizza Base (Regular)", new BigDecimal("1.00")),
    CALZONE("Pizza Base (Calzone)", new BigDecimal("1.50"));

    public final String label;
    public final BigDecimal price;

    PizzaType(String label, BigDecimal price) {
        this.label = label;
        this.price = price;
    }
}
