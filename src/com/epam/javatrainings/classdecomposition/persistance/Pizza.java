package com.epam.javatrainings.classdecomposition.persistance;

import java.util.List;

public class Pizza {
    private String name;
    private String type = "regular";
    private List<Ingredient> ingredients;
    private int quantity = 1;
    private double pizzaBaseCost = 1;

    public Pizza(String name, String type, int quantity) {
        this.setName(name);
        this.setType(type);
        this.setQuantity(quantity);
    }

    public Pizza() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 4 && name.length() <= 20 && name.matches("^[a-zA-Z ]+")) {
            this.name = name;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if ("closed".equals(type)) {
            this.type = type;
        }
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0 && quantity <= 10) {
            this.quantity = quantity;
        } else if (quantity > 10){
            this.quantity = 10;
        }
    }

    public double getPizzaBaseCost() {
        if (this.getType().equals("closed")) {
            this.pizzaBaseCost = 1.5;
        }
        return this.pizzaBaseCost;
    }

}
