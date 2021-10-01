package com.epam.javatrainings.pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Type type;
    private List<Ingredient> ingredients;

    private int quantity;

    public Pizza(final String name, final Type type) {
        this.name = name;
        this.type = type;
        ingredients = new ArrayList<>();
    }

    public Pizza(final String name, final Type type, final List<Ingredient> ingredients) {
        this.name = name;
        this.type = type;
        this.ingredients = ingredients;
    }

    public void addIngredient(String name) {
        try {
            IngredientType ingredientType = IngredientType.findByName(name);
            Ingredient e = new Ingredient(name, ingredientType.getPrice());
            ingredients.add(e);
            System.out.println(name);

        } catch (IllegalArgumentException e) {
            System.out.println("no such ingredient");
        }
    }

    public static String pickPizzaName(String pizzaName, Customer customer) {
        if (pizzaName.length() < 4 || pizzaName.length() > 20) {
            String name = customer.getName();
            System.out.println("Wrong name: " + name);
            return null;
        }

        if (PizzaUtils.PIZZA_NAMES.contains(pizzaName)) {
            System.out.println("You choose pizza: " + pizzaName);
            return pizzaName;
        }

        String specialName = customer.getName();
        System.out.println("Special for you: " + specialName);
        return specialName;
    }

    public Type getType() {
        return type;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}