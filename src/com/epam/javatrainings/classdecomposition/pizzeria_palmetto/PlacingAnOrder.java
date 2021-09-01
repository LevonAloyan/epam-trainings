package com.epam.javatrainings.classdecomposition.pizzeria_palmetto;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlacingAnOrder implements OrderCreator {
    static int initialNumberOrder = 10000;
    private final int orderNumber;
    private final Customer customer;
    private final List<Pizza> orderItems = new ArrayList<>();
    public static final Set<Integer> savedOrderNumber = new HashSet<>();
    private final LocalTime localTime;

    public PlacingAnOrder(Customer customer) {
        this.orderNumber = initialNumberOrder++;
        this.customer = customer;
        this.localTime = LocalTime.now();
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Pizza> getOrderItems() {
        return orderItems;
    }

    @Override
    public Pizza create(String name, String type, int quantity, PlacingAnOrder order) {
        Pizza pizza = new Pizza(name, type, quantity, this);
        savedOrderNumber.add(getOrderNumber());
        orderItems.add(pizza);
        return pizza;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public double costOrder() {
        double orderCost = 0;
        for (Pizza pizza : orderItems) {
            orderCost += pizza.getCostPizza() * pizza.getQuantity();
        }
        return orderCost;
    }

    public void printCheck() {
        System.out.println("********************************");
        System.out.println("Order: " + getOrderNumber());
        System.out.println("Client: " + customer.getNumberCustomer());
        System.out.println("Time: " + this.getLocalTime());
        for (Pizza pizza : getOrderItems()) {
            System.out.println("Name: " + pizza.getName());
            System.out.println("--------------------------------");
            System.out.println("Pizza Base " + "(" + pizza.getType() + ")" + pizza.getType().getCost() + " €");

            for (String ingredient : Pizza.ingredientsList) {
                for (Ingredients ingredients : Ingredients.values()) {
                    if (ingredients.getKey().equals(ingredient)) {
                        System.out.println(ingredient + " " + ingredients.getCost());
                    }
                }
            }
            System.out.println("--------------------------------");
            System.out.println("Amount: " + pizza.getCostPizza() + " €");
            System.out.println("Quantity: " + pizza.getQuantity());
            System.out.println("--------------------------------");
        }
        System.out.println("Total amount: " + costOrder() + " €");
        System.out.println("********************************");
    }

}

