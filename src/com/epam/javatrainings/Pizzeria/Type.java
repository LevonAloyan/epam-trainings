package com.epam.javatrainings.Pizzeria;

public class Type {
    private String Name;
    private double Price;
    public Type(String name, double price ) {
        Name=name;
        Price=price;
    }
    public String GetName() {
        return Name;
    }
    public double GetPrice() {
        return Price;
    }
}
