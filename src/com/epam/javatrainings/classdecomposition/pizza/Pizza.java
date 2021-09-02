package com.epam.javatrainings.classdecomposition.pizza;

import com.epam.javatrainings.classdecomposition.ingredient.Ingredient;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class Pizza {
    private final BigDecimal basePrice = new BigDecimal("1.0");
    private final BigDecimal calzonePrice = new BigDecimal("0.5");
    private final PizzaType type;
    private final List<Ingredient> ingredients;
    private String name;

    public Pizza(String initialName, PizzaType type, List<Ingredient> ingredients) {
        name = initialName;
        this.type = type;
        this.ingredients = ingredients;
    }

    public Pizza(String initialName, PizzaType type) {
        this(initialName, type, new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isValidName() {
        return ((name != null) &&
                name.length() >= 4 &&
                name.length() <= 20 &&
                name.matches("\\p{IsLatin}+"));
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "basePrice=" + basePrice +
                ", calzonePrice=" + calzonePrice +
                ", initialName='" + getName() + '\'' +
                ", type=" + type +
                ", ingredients=" + ingredients +
                '}';
    }
}
