package com.epam.javatrainings.classdecomposition;

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
}
