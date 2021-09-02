package com.epam.javatrainings.classdecomposition.customer;

public class Customer {
    private static int initialCustId = 0;

    private final int id;
    private final String name;

    private Customer(Customer c) {
        this.id = c.getCustomerId();
        this.name = c.getName();
    }

    public Customer(String name) {
        this.name = name;
        id = initialCustId++;
    }


    public Customer getCustomerCopy() {
        return new Customer(this);
    }

    public int getCustomerId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
