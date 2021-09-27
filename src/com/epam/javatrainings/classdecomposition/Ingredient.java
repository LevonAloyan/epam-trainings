package com.epam.javatrainings.classdecomposition;

public class Ingredient {
    private String name;
    private double price;

    public Ingredient() {
        name = null;
        price = 0.0;
    }

    public Ingredient(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
