package com.epam.javatrainings.classdecomposition;

public enum PizzaType {
    REGULAR (1f),
    CLOSED (1.5f);

    private final float value;

    private PizzaType(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }
}
