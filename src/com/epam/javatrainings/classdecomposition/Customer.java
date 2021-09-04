package com.epam.javatrainings.classdecomposition;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private long phone;
    private String name;
    private List<Order> orders = new ArrayList<>();

    public Customer(long phone, String name) {
        this.phone = phone;
        this.name = name;
    }

    public void addOrderToCustomerOrderList(Order order) {
        orders.add(order);
    }

    public long getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrders() {
        return orders;
    }
}

