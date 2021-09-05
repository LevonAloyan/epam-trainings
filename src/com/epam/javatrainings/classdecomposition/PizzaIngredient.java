package com.epam.javatrainings.classdecomposition;

public enum PizzaIngredient {
    Tomato_paste (1f),
    Cheese (1f),
    Salami (1.5f),
    Bacon (1.2f),
    Garlic (0.3f),
    Corn (0.7f),
    Pepperoni (0.6f),
    Olives (0.5f);

    private final float value;

    private PizzaIngredient(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }
}
