package com.epam.javatrainings.classdecomposition;

import java.time.format.DateTimeFormatter;

public class Helper {
    private Helper() {

    }

    public static String validatePizzaName(String name, Order order) {
        if (name.length() < 4 || name.length() > 20) {
            return order.getCustomer().getName() + "_" + order.getOrderNumber();
        }

        return name;
    }

    public static void displayAttributes(Pizza pizza, Order order) {
        System.out.println("[" + order.getOrderNumber() + " : " + order.getCustomer().getId() + ": " + pizza.getName() + ": " + pizza.getQuantity() + "]");
    }

    public static void printCheck(Order order) {
        var pizzaTypeNames = Pizza.getPizzaTypeNames();
        var offeredIngredients = Pizza.offeredIngredients;

        System.out.println("********************************");

        System.out.println("Time: " +  order.getLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println("Order: " + order.getOrderNumber());
        System.out.println("Client: " + order.getCustomer().getId());

        for (Pizza pizza : order.getOrderItems()) {
            System.out.println("Name: " + pizza.getName());
            System.out.println("--------------------------------");
            System.out.println("Pizza Base (" + pizzaTypeNames.get(pizza.getType()) + ") " + (pizza.getType() == Pizza.TYPE_REGULAR ? 1 : 1.5) + " €");

            for (String ingredient : pizza.getIngredients()) {
                System.out.println(ingredient + " " + offeredIngredients.get(ingredient) + " €");
            }

            System.out.println("--------------------------------");
            System.out.println("Amount: " + pizza.getCost() + " €");
            System.out.println("Amount: " + pizza.getQuantity());
            System.out.println("--------------------------------");
        }

        System.out.println("Total amount: " + order.cost() + " €");
        System.out.println("********************************");
    }
}
