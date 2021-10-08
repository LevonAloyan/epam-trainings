package com.epam.javatrainings.classdecomposition.model;

/**
 * Created by Hayk on 31.08.2021.
 */
public class Customer {
    private int id;
    private String name;
    private Order order;
    private static int idSequence = 10000;

    public Customer(String name) {
        this.name = name;
        this.id = ++idSequence;
        order = new Order(id);
    }

    public Customer(int id, String name) {
        this.name = name;
        this.id = id;
        order = new Order(id);
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
