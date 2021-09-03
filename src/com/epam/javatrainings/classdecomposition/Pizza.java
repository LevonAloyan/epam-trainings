package com.epam.javatrainings.classdecomposition;

import java.util.ArrayList;

public class Pizza {


    enum Piiza {
        REGULAR, CARLZONE;
    }

    static int x = 0;
    private String name;
    private int client;
    private double price;
    private String dough;
    private ArrayList<String> ingredient;
    private Order order;



    public Pizza(String name, double price, String dough, ArrayList<String> ingredient,Order order ) {
        this.name = name;
        this.client = ++x;
        this.price = price;
        this.dough = dough;
        this.ingredient = ingredient;
        this.order=order;
    }

    public Pizza() {
        this.client = ++x;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClient() {
        return client;
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

    public Order getOrder() {
        return order;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public ArrayList<String> getIngredient() {
        return ingredient;
    }

    public void setIngredient(ArrayList<String> ingredient) {
        this.ingredient = ingredient;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", client=" + client +
                ", price=" + price +
                ", dough='" + dough + '\'' +
                ", ingredient=" + ingredient +
                ", order=" + order +
                '}';
    }

}
