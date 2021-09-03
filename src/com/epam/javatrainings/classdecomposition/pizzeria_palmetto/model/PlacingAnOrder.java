package com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model;

import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services.OrderCreator;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PlacingAnOrder implements OrderCreator {
    static int initialNumberOrder = 10000;
    private final int orderNumber;
    private final Customer customer;
    private final List<Pizza> orderItems = new ArrayList<>();
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
    public Pizza create(String name, String type, int quantity) {
        Pizza pizza = new Pizza(name, type, quantity, this);
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

}

