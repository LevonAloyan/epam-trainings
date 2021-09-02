package com.epam.javatrainings.classdecomposition.pizza;

import com.epam.javatrainings.classdecomposition.ingredient.Ingredient;
import com.epam.javatrainings.classdecomposition.ingredient.IngredientListUtil;
import com.epam.javatrainings.classdecomposition.ingredient.AvailableIngredientList;

import java.util.List;
import java.util.ArrayList;

public final class Pizza {
    private static final double REGULAR_PRICE = 1.0;
    private static final double CALZONE_PRICE = 0.5;
    private static final String BASE_NAME = "Pizza Base (Regular)";
    private static final String CALZONE_NAME = "Pizza Base (Calzone)";

    private String name;
    private final PizzaType type;
    private final List<Ingredient> ingredients;

    public Pizza(String name, PizzaType type, List<Ingredient> ingredients) {
        this.name = name;
        this.type = type;
        this.ingredients = IngredientListUtil.copyIngredientList(ingredients);
    }

    public Pizza(String name, PizzaType type) {
        this(name, type, new ArrayList<>());
    }

    public Pizza(Pizza p) {
        this(p.name, p.type, p.ingredients);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public void updateName(Pizza p, String validName) {
        p.setName(validName);
    }

    public boolean isValidName() {
        return ((name != null) &&
                name.length() >= 4 &&
                name.length() <= 20 &&
                name.matches("\\p{IsLatin}+"));
    }

    public boolean addIngredient(Ingredient ingredient) {
        if (ingredient != null && ingredient.isAvailable() &&
                !isFull() && !hasGivenIngredient(ingredient)
        ) {
            ingredients.add(new Ingredient(ingredient));
            return true;
        }
        return false;
    }

    private boolean isFull() {
        if (ingredients.size() == AvailableIngredientList.getInstance().getAvailableIngredientsCount()) {
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

    public String getBaseDescription() {
        String baseName = PizzaType.REGULAR.equals(type) ? BASE_NAME : CALZONE_NAME;
        double basePrice = PizzaType.REGULAR.equals(type) ? REGULAR_PRICE : CALZONE_PRICE;
        return baseName
                .concat(" ")
                .concat(String.valueOf(basePrice))
                .concat(" ")
                .concat("€");
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", ingredients=" + ingredients +
                '}';
    }
}
