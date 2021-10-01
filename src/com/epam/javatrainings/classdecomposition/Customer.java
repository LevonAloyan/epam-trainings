package com.epam.javatrainings.classdecomposition;

public class Customer {

    private int id;
    private String customerName;

    public Customer(int id, String name) {
        this.id = id;
        this.customerName = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
