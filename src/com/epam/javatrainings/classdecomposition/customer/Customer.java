package com.epam.javatrainings.classdecomposition.customer;

public class Customer {
    private static int initialCustId = 0;

    private final int id;
    private final String name;

    public Customer(String name) {
        this.name = name;
        id = initialCustId++;
    }

    public int getCustomerId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
