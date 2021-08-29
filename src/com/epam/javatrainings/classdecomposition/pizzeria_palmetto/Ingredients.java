package com.epam.javatrainings.classdecomposition.pizzeria_palmetto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Ingredients {
    TOMATO_PASTE("Tomato paste", 1.0),
    CHEESE("Cheese", 1.0),
    SALAMI("Salami", 1.5),
    BACON("Bacon", 1.2),
    GARLIC("Garlic", 0.3),
    CORN("Corn", 0.7),
    PEPPERONI("Pepperoni", 0.6),
    Olives("Olives", 0.5);
    private final String key;
    private final Double cost;
    private static List<Ingredients> ingredientsList = new ArrayList<>();

    Ingredients(String key, Double cost) {
        this.key = key;
        this.cost = cost;
    }

    public String getKey() {
        return key;
    }

    public void setList(List<Ingredients> list) {
        this.ingredientsList = list;
    }

    public List<Ingredients> getList() {
        return ingredientsList;
    }

    public Double getCost() {
        return cost;
    }

    public static void showIngredient() {
        for (Ingredients ingredients : Ingredients.values()) {
            System.out.println("Ingredient --> " + ingredients.getKey() + " - " + ingredients.getCost() + "$");
        }
    }
}