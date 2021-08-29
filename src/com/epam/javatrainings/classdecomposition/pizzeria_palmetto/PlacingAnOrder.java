package com.epam.javatrainings.classdecomposition.pizzeria_palmetto;

import java.util.ArrayList;
import java.util.List;

public class PlacingAnOrder implements OrderCreator {
    private final int orderNumber;
    private final int customerNumber;
    private final List<Pizza> orderItems = new ArrayList<>();
    private static final List<Integer> savedOrderNumber = new ArrayList<>();

    public PlacingAnOrder(Customer customer) {
        this.orderNumber = GeneratorNumber.initialNumberOrder++;
        this.customerNumber = customer.getNumberCustomer();
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public List<Pizza> getOrderItems() {
        return orderItems;
    }

    @Override
    public boolean create(Customer customer, String type, int quantity) {
        final Pizza pizza = new Pizza(customer, type, quantity, this);
        savedOrderNumber.add(getOrderNumber());
        return orderItems.add(pizza);
    }

    static class GeneratorNumber {
        public static int initialNumberOrder = 10000;
        public static int initialNumberCustomer = 1000;
    }

}

