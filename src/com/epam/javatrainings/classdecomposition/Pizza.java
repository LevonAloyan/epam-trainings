package com.epam.javatrainings.classdecomposition;

import java.util.HashSet;

public class Pizza {

    private String name;
    private PizzaType type;
    private int quantity;

    private HashSet<Ingredient> ingredients;

    public Pizza(String name, PizzaType type, int quantity) {
        this.type = type;
        this.name = name;
        this.setQuantity(quantity);

        ingredients = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PizzaType getType() {
        return type;
    }

    public void setType(PizzaType type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public HashSet<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setQuantity(int quantity) {
        if (quantity > 10) {
            System.out.println("The quantity can not be more than 10 items");
            quantity = 10;
        } else if (quantity <= 0) {
            quantity = 1;
        }

        this.quantity = quantity;
    }

    public boolean addIngredient(Ingredient ingredient) {
        if (ingredients.size() == Ingredient.values().length) {
            System.out.println("The pizza is already full");
            return false;
        }

        boolean ingredientAdded = ingredients.add(ingredient);

        if (!ingredientAdded) {
            System.out.println("Duplicate Ingredient, please check the order again");
        }

        return ingredientAdded;
    }

    public double getSinglePizzaCost() {
        double cost = 0;
        for (Ingredient ingredient: ingredients) {
            cost += ingredient.getPrice();
        }

        cost += this.type == PizzaType.REGULAR ? 1 : 1.5;

        return cost;
    }
}
