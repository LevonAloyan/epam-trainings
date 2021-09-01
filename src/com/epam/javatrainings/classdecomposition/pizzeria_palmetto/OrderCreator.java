package com.epam.javatrainings.classdecomposition.pizzeria_palmetto;

public interface OrderCreator {
    Pizza create(String name, String type, int quantity,PlacingAnOrder order);

}
