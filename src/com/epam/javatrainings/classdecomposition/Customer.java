package com.epam.javatrainings.classdecomposition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Serializable {
    private final long phone;
    private final String name;
    private final List<Order> orders = new ArrayList<>();

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

