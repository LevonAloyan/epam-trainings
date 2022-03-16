package com.epam.javatrainings.classdecomposition;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private float cost;
    private String name;
    private PizzaType type;
    private List<PizzaIngredient> ingredients;

    public Pizza() {
        this.ingredients = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(PizzaType type) {
        this.type = type;
        setCost();
    }

    public void setIngredients(PizzaIngredient ingredient) {
        this.ingredients.add(ingredient);
        setCost();
    }

    public void setCost() {
        this.cost = type.getValue();
        ingredients.forEach(e -> cost += e.getValue());
    }

    public float getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public PizzaType getType() {
        return type;
    }

    public List<PizzaIngredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(PizzaIngredient ingredient) {
        if (ingredients.size() == PizzaIngredient.values().length) {
            System.out.println("pizza is full");
        } else if (ingredients.contains(ingredient)) {
            System.out.println("check the order again");
        } else {
            ingredients.add(ingredient);
        }

    }
}
