package com.epam.javatrainings.classdecomposition.pizzeria_palmetto;

public interface OrderCreator {
    boolean create(Customer customer, String type, int quantity);

}
