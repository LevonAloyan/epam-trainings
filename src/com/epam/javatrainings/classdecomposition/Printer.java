package com.epam.javatrainings.classdecomposition;

import java.time.format.DateTimeFormatter;

public class Printer {
    private Printer() {
        throw new IllegalStateException("No instances");
    }

    public static void printAttributes(Pizza pizza, Order order) {
        System.out.println("[" + order.getOrderNumber() + " : " + order.getCustomer().getId() + ": " + pizza.getName() + ": " + pizza.getQuantity() + "]");
    }

    public static void printCheck(Order order) {
        System.out.println("********************************");

        System.out.println("Time: " +  order.getLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println("Order: " + order.getOrderNumber());
        System.out.println("Client: " + order.getCustomer().getId());

        for (Pizza pizza : order.getOrderItems()) {
            System.out.println("Name: " + pizza.getName());
            System.out.println("--------------------------------");
            System.out.println("Pizza Base (" + pizza.getType() + ") " + (pizza.getType() == PizzaType.REGULAR ? 1 : 1.5) + " €");

            for (Ingredient ingredient : pizza.getIngredients()) {
                System.out.println(ingredient + " " + ingredient.getPrice() + " €");
            }

            System.out.println("--------------------------------");
            System.out.println("Amount: " + pizza.getSinglePizzaCost() + " €");
            System.out.println("Amount: " + pizza.getQuantity());
            System.out.println("--------------------------------");
        }

        System.out.println("Total amount: " + order.cost() + " €");
        System.out.println("********************************");
    }
}
