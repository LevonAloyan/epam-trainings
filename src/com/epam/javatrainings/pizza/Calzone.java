package com.epam.javatrainings.pizza;

import java.util.List;

public class Calzone extends Pizza {

    public Calzone(int orderNumber) {
        super(orderNumber);
        setBasePrice(1.5);
    }

    @Override
    public double calculatePrice() {
        double price = getBasePrice();
        List<Ingredient> ingredients = getIngredients();
        for (Ingredient ingredient : ingredients) {
            price += ingredient.getCost();
        }
        return price * getQuantity();
    }
}
