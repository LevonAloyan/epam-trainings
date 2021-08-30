package com.epam.javatrainings.homework2;

import java.util.ArrayList;
import java.util.List;

public class PizzaOrder {
    private static int orderCurrentNumber = 10000;

    private int orderNumber;
    private Customer customer;
    private List<Pizza> orderItems = new ArrayList<Pizza>();

    public PizzaOrder(Customer customer) {
        orderNumber = orderCurrentNumber++;
        this.customer = customer;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Pizza addOrderItem(String name, int type, int quantity) {
        Pizza pizza = new Pizza(this.customer, this, name, type, quantity);
        orderItems.add(pizza);

        return pizza;
    }

    public double cost() {
        double totalCost = 0;
        for (Pizza pizza : orderItems) {
            totalCost += pizza.getCost();
        }

        return totalCost;
    }
}
