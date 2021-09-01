package com.epam.javatrainings.pizza;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    private final int orderNumber;
    private int quantity;
    private double basePrice;
    private String name;
    private List<Ingredient> ingredients;

    public Pizza(int orderNumber) {
        this.orderNumber = orderNumber;
        ingredients = new ArrayList<>();
    }

    public abstract double calculatePrice();

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }


    public void setName(String name) {
        assert name.length() >= 4 && name.length() <= 20 : "Name must contain grater than 3 and less than 21 characters";
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }
}
