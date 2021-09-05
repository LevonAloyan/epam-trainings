package com.epam.javatrainings.classdecomposition;

import java.util.Map;

public class Printer {
    public static void print(Order obj) {
//        Order: Customer: Name: Quantity

        System.out.printf("%s : %s : ",  obj.getOrderNumber(), obj.getCustomerNumber());
        obj.getPizzas().forEach((e, c) -> System.out.printf("%s : %s,  ", e.getName(), c));
    }

    public static void printCheck(Order order) {
        System.out.printf("Time: %s", order.getOrderTime());
        System.out.printf("Order: %s\n", order.getOrderNumber());
        System.out.printf("Client: %s\n", order.getCustomerNumber());

        order.getPizzas().forEach((pizza, count) -> {
            System.out.printf("Name: %s\n", pizza.getName());
            System.out.println("---------------------------------");

            System.out.printf("Pizza Base (%s) %s €\n", pizza.getType(), pizza.getType().getValue());

            pizza.getIngredients().forEach(ingredient -> {
                System.out.printf("%s %s €\n", ingredient, ingredient.getValue());
            });
            System.out.println("---------------------------------");

            System.out.printf("Amount: %s €\n", pizza.getCost());
            System.out.printf("Quantity: %s\n", count);
            System.out.println("---------------------------------");
        });

        System.out.printf("Total amount: %s €\n", order.getOrderCost());
    }
}
