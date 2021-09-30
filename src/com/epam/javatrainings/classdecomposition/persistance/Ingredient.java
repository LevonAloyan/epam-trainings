package com.epam.javatrainings.classdecomposition.persistance;

import com.epam.javatrainings.classdecomposition.service.IngredientService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ingredient {
    private String name = "Tomato paste";
    private double cost = 1;

    public Ingredient(String name) {
        this.setName(name);
    }

    public Ingredient() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        List<String> ingredientNames = new ArrayList<>(Arrays.asList("Tomato paste", "Cheese", "Salami", "Bacon", "Garlic", "Corn", "Pepperoni", "Olives"));
        for (String ingredientName : ingredientNames) {
            if (name.toLowerCase().equals(ingredientName.toLowerCase())) {
                this.name = name;
                break;
            }
        }
        this.name = name;
    }

    public double getCost() {
        return IngredientService.checkIngredientFixedCost(this.name);
    }
}
