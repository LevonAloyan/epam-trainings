package com.epam.javatrainings.classdecomposition.pizzeria_palmetto;

public class Customer {
    private final int numberCustomer;
    private final String nameCustomer;

    public Customer(String nameCustomer, int numberCustomer) {
        this.numberCustomer = numberCustomer;
        this.nameCustomer = nameCustomer;
    }

    public int getNumberCustomer() {
        return numberCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

}
