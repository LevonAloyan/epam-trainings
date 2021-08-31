package com.epam.javatrainings.classdecomposition;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to pizzeria 'PALMETTO'");
        Customer customer = new Customer();

        Scanner scanner = new Scanner(System.in);
        Pizza.pizzaName();

        Ingredients[] pizzaIngredients = new Ingredients[10];

        pizzaIngredients[0] = new Ingredients("Tomato paste", 1);
        pizzaIngredients[1] = new Ingredients("Cheese", 1);
        pizzaIngredients[2] = new Ingredients("Salami", 1.5);
        pizzaIngredients[3] = new Ingredients("Bacon", 1.2);
        pizzaIngredients[4] = new Ingredients("Garlic", 0.3);
        pizzaIngredients[5] = new Ingredients("Corn", 0.7);
        pizzaIngredients[6] = new Ingredients("Pepperoni", 0.6);
        pizzaIngredients[7] = new Ingredients("Olives", 0.5);

        pizzaIngredients[8] = new Ingredients("Pizza Base Regular", 1);
        pizzaIngredients[9] = new Ingredients("Pizza Base Calzone", 1.5);
    }
}
