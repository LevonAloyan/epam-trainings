package com.epam.javatrainings.classdecomposition.ingredient;

import java.util.*;

public class PizzaIngredients {
    private static final List<Ingredient> pizzaIngredients =
            Collections.unmodifiableList(new ArrayList<>(
                    Arrays.asList(
                            new Ingredient("Tomato paste", 1),
                            new Ingredient("Cheese", 1),
                            new Ingredient("Salami", 1.5),
                            new Ingredient("Bacon", 1.2),
                            new Ingredient("Garlic", 0.3),
                            new Ingredient("Corn", 0.7),
                            new Ingredient("Pepperoni", 0.6),
                            new Ingredient("Olives", 0.5)
                    )
            ));

    public static List<Ingredient> getPizzaIngredients() {
        return pizzaIngredients;
    }
}
