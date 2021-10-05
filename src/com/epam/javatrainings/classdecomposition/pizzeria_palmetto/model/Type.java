package com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model;

public enum Type {
    REGULAR("regular", 1.0), CALZONE("calzone", 1.5);
    private final double cost;
    private final String key;

    Type(String key, double cost) {
        this.cost = cost;
        this.key = key;
    }

    public double getCost() {
        return cost;
    }

    public String getKey() {
        return key;
    }

}
