package com.epam.javatrainings.classdecomposition.item.pizza;

import com.epam.javatrainings.classdecomposition.ingredient.Ingredient;
import com.epam.javatrainings.classdecomposition.item.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class Pizza extends Item {
    private final BigDecimal basePrice = new BigDecimal("1.0");
    private final BigDecimal calzonePrice = new BigDecimal("0.5");
    private final PizzaType type;
    private final List<Ingredient> ingredients;

    public Pizza(String initialName, PizzaType type, List<Ingredient> ingredients) {
        super(initialName);
        this.type = type;
        this.ingredients = ingredients;
    }

    public Pizza(String name, PizzaType type) {
        this(name, type, new ArrayList<>());
    }

    @Override
    public boolean isValidName() {
        String name = getName();
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
