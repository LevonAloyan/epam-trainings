package com.epam.javatrainings.classdecomposition;

import java.util.HashMap;
import java.util.HashSet;

public class Pizza {
    public static final HashMap<String, Double> offeredIngredients;

    static {
        offeredIngredients = new HashMap<>();
        offeredIngredients.put("Tomato paste", 1.0);
        offeredIngredients.put("Cheese", 1.0);
        offeredIngredients.put("Salami", 1.5);
        offeredIngredients.put("Bacon", 1.2);
        offeredIngredients.put("Garlic", 0.3);
        offeredIngredients.put("Corn", 0.7);
        offeredIngredients.put("Pepperoni", 0.6);
        offeredIngredients.put("Olives", 0.5);
    }

    private String name;
    private PizzaType type;
    private int quantity;

    private HashSet<String> ingredients;

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

    public void setQuantity(int quantity) {
        if (quantity > 10) {
            System.out.println("The quantity can not be more than 10 items");
            quantity = 10;
        } else if (quantity <= 0) {
            quantity = 1;
        }

        this.quantity = quantity;
    }

    public HashSet<String> getIngredients() {
        return ingredients;
    }

    public boolean addIngredient(String ingredient) {
        if (ingredients.size() == offeredIngredients.size()) {
            System.out.println("The pizza is already full");
            return false;
        }

        if (!offeredIngredients.keySet().contains(ingredient)) {
            System.out.println("Invalid Ingredient");
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
        for (String ingredient: ingredients) {
            cost += offeredIngredients.get(ingredient);
        }

        cost += this.type == PizzaType.REGULAR ? 1 : 1.5;

        return cost;
    }
}
