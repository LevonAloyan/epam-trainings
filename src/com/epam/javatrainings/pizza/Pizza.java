package com.epam.javatrainings.pizza;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    private int orderNumber;
    private int quantity;
    private double basePrice;
    private String name;
    private final List<Ingredient> ingredients;

    public Pizza() {
        ingredients = new ArrayList<>();
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
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

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        List<Ingredient> cloneList = this.ingredients; //To avoid adding other Ingredients in main list by using this getter
        return cloneList;
    }

    public void addIngredient(Ingredient ingredient) {
        assert !ingredients.contains(ingredient) : "The Ingredient : " + ingredient + " you are trying to add has already been added";
        assert ingredients.size() < 7 : "The Pizza is already full, you can't add more ingredients";

        ingredients.add(ingredient);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
