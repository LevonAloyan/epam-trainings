package com.epam.javatrainings.pizza;

import java.util.HashMap;
import java.util.Map;

public class Data {

    private final Map<String, Pizza> pizzas = new HashMap<>();
    private final Map<String, Double> ingredients = new HashMap<>();


    public Map<String, Pizza> pizza() {
        Pizza cheese = new Pizza("cheese", 2);
        Pizza peperoni = new Pizza("peperoni", 4);
        Pizza meat = new Pizza("meat", 5);
        Pizza chicken = new Pizza("chicken", 3.5F);
        Pizza veggie = new Pizza("veggie", 2.5F);
        Pizza margherita = new Pizza("margherita", 2.5F);
        Pizza pineapple = new Pizza("pineapple", 3);
        Pizza supreme = new Pizza("supreme", 6);
        Pizza bbq = new Pizza("bbq", 5.5F);
        Pizza hawaiian = new Pizza("hawaiian", 6);

        pizzas.put("cheese", cheese);
        pizzas.put("pepperoni", peperoni);
        pizzas.put("meat", meat);
        pizzas.put("chicken", chicken);
        pizzas.put("veggie", veggie);
        pizzas.put("margherita", margherita);
        pizzas.put("pineapple", pineapple);
        pizzas.put("supreme", supreme);
        pizzas.put("bbq", bbq);
        pizzas.put("hawaiian", hawaiian);

        return pizzas;
    }

    public Map<String, Double> ingredient() {
        ingredients.put("tomato paste", 1.0);
        ingredients.put("cheese", 1.0);
        ingredients.put("salami", 1.5);
        ingredients.put("bacon", 1.2);
        ingredients.put("garlic", 0.3);
        ingredients.put("corn", 0.7);
        ingredients.put("pepperoni", 0.6);
        ingredients.put("olives", 0.5);
        return ingredients;
    }

    public void printIngredient() {
        System.out.println("""
                ingredients  1 : Tomato paste 1$ \s
                             2 : Cheese 1$ \s
                             3 : Salami 1.5$ \s
                             4 : Bacon 1.2$ \s
                             5 : Garlic 0.3$ \s
                             6 : Corn 0.7$ \s
                             7 : Pepperoni 0.6$ \s
                             8 : Olives 0.5$ \s
                """);
        System.out.println("Choose ingredients from the list above!");
    }

    public void menu() {
        System.out.println("""
                Menu  1 : Cheese 2$ \s
                      2 : Pepperoni 4$ \s
                      3 : Meat 5$ \s
                      4 : Chicken 3.5$ \s
                      5 : Veggie 2.5$ \s
                      6 : Margherita 2.5$ \s
                      7 : Pineapple 3$ \s
                      8 : Supreme 6$ \s
                      9 : BBQ 5.5$ \s
                     10 : Hawaiian 6$ \s
                """);
    }

    public void type() {
        System.out.println("Enter 1 for regular pizza and 2 for closed (calzone)");
        System.out.println("Regular costs 1.00$ and the closed costs 1.50$");
    }


}
