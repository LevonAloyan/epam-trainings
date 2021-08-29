package com.epam.javatrainings.classdecomposition.pizzeria_palmetto;

public enum Type {
    REGULAR("regular", 1.0), CALZONE("calzone", 1.5);
    private double cost;
    private String key;

    Type(String key, double cost) {
        this.cost = cost;
        this.key = key;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
