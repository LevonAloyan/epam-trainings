package com.epam.javatrainings.classdecomposition;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        //test for the first customer
        Order order1 = new Order();

        Pizza pizza1 = new Pizza("Margarita", 2, Pizza.Type.CALZONE);
        Pizza pizza2 = new Pizza("PepperoniOro", 3, Pizza.Type.REGULAR);

        //ingredients for Margarita
        pizza1.addIngredient(Pizza.allAvailableIngredients.get(0));
        pizza1.addIngredient(Pizza.allAvailableIngredients.get(6));
        pizza1.addIngredient(Pizza.allAvailableIngredients.get(4));
        pizza1.addIngredient(Pizza.allAvailableIngredients.get(3));

        //ingredients for PepperoniOro
        pizza2.addIngredient(Pizza.allAvailableIngredients.get(0));
        pizza2.addIngredient(Pizza.allAvailableIngredients.get(1));
        pizza2.addIngredient(Pizza.allAvailableIngredients.get(2));
        pizza2.addIngredient(Pizza.allAvailableIngredients.get(7));

        order1.placeOrder(pizza1, new Customer(7717, "Emin"));
        order1.placeOrder(pizza2, new Customer(7717, "Emin"));

        Pizzeria.printCheck(order1);


        //test for the second customer
        Order order2 = new Order();

        Pizza pizza3 = new Pizza("BasePZZ", 12, Pizza.Type.REGULAR);
        order2.placeOrder(pizza3, new Customer(4372, "Vaspur"));

        Pizzeria.printCheck(order2);


        /*
        * to test with input parameters
        */

        Pizzeria.startApp();

    }
}



