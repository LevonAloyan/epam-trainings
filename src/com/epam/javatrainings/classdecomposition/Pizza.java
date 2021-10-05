package com.epam.javatrainings.classdecomposition;

import java.lang.reflect.Type;
import java.util.Random;

public class Pizza {

    public Pizza() {

    }

    enum Piiza {
        REGULAR, CARLZONE;
    }

    private String name;
    private int count;
    private double price;
    private String dough;



    public Pizza(String name, int count, double price, String dough) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", dough=" + dough +
                '}';
    }
}
