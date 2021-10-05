package com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services;

import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.Ingredients;
import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.Pizza;
import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.PlacingAnOrder;

public class PizzaService implements IngredientsCreator {
    private final Pizza pizza;
    public PizzaService(Pizza pizza) {
        this.pizza=pizza;
    }

    public void printAttributes( PlacingAnOrder order){
         System.out.println("[" + order.getOrderNumber() +
                ":" + order.getCustomer().getNumberCustomer() +
                ":" + pizza.getName() +
                ":" + pizza.getQuantity() + "]");
    }

    @Override
    public boolean addIngredient(String ingredient) {
        if (Pizza.ingredientsList.size() == Ingredients.values().length) {
            System.out.println("The pizza is already full");
            return false;
        }
        if (Pizza.ingredientsList.contains(ingredient)) {
            System.out.println("Duplicate Ingredient, please check the order again");
            return false;
        }
        for (Ingredients ingredients : Ingredients.values()) {
            if (ingredients.getKey().equals(ingredient)) {
                Pizza.ingredientsList.add(ingredient);
            }
        }
        return true;
    }
}
