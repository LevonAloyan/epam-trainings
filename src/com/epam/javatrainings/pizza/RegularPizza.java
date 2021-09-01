package com.epam.javatrainings.pizza;

import java.util.List;

public class RegularPizza extends Pizza {

    public RegularPizza() {
        setBasePrice(1.0);
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
