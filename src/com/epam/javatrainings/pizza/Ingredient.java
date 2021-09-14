package com.epam.javatrainings.pizza;

public class Ingredient {

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Ingredient(final String name, final double price) {
        this.name = name;
        this.price = price;
    }
}
