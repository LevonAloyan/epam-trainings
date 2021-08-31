package com.epam.javatrainings.classdecomposition.model;

/**
 * Created by Hayk on 31.08.2021.
 */
public class Customer {
    private int id;
    private String name;
    private static int idSequence = 10000;

    public Customer(String name) {
        this.name = name;
        this.id = ++idSequence;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
