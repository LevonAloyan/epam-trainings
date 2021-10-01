package com.epam.javatrainings.homework_2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Ingredients> ingredientsOfMargarita = new ArrayList<>(7);
        ingredientsOfMargarita.add(Ingredients.CHEESE);
        ingredientsOfMargarita.add(Ingredients.BACON);
        ingredientsOfMargarita.add(Ingredients.GARLIC);
        ingredientsOfMargarita.add(Ingredients.TOMOTO_PASTE);
        ingredientsOfMargarita.add(Ingredients.PEPPERONI);
        RegularPizza pizza = new RegularPizza(ingredientsOfMargarita, "Margarita", 8);

        List<Ingredients> ingredientsOfPepperoni = new ArrayList<>(7);
        ingredientsOfPepperoni.add(Ingredients.PEPPERONI);
        ingredientsOfPepperoni.add(Ingredients.TOMOTO_PASTE);
        ingredientsOfPepperoni.add(Ingredients.CHEESE);

        ClosedPizza pizza1 = new ClosedPizza(ingredientsOfPepperoni, "Pepperoni", 7);

        Order order = new Order(12345, 1, 676722, pizza, "Shushoook");
        order.showDetails(pizza.getCount(), pizza.getPizzaName());

    }
}
