package com.epam.javatrainings.classdecomposition.pizza;

import com.epam.javatrainings.classdecomposition.ingredient.Ingredient;
import com.epam.javatrainings.classdecomposition.ingredient.PizzaIngredients;

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

    public boolean addIngredient(Ingredient ingredient) {
        if (isAvailable(ingredient) && !(isFull() && hasGivenIngredient(ingredient))) {
            ingredients.add(ingredient);
            return true;
        }

        return false;
    }

    private boolean isAvailable(Ingredient ingredient) {
        return PizzaIngredients.getPizzaIngredients().contains(ingredient);
    }

    private boolean isFull() {
        if (ingredients.size() == PizzaIngredients.getPizzaIngredients().size()) {
            System.out.println("Pizza is full");
            return true;
        }
        return false;
    }

    private boolean hasGivenIngredient(Ingredient ingredient) {
        if (ingredients.contains(ingredient)) {
            System.out.println("Please check order again");
            return true;
        }
        return false;
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
