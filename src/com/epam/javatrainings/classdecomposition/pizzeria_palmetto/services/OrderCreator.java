package com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services;

import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.Pizza;

public interface OrderCreator {
    Pizza create(String name, String type, int quantity);

}
