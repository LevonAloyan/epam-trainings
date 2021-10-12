package com.epam.javatrainings.Pizzeria;

public class Ingredient {
    private String Name;
    private double Price;
    public Ingredient(String name,double price) {
      Name=name;
      Price=price;
    }
    public String GetName() {
      return Name;
    }
    public double GetPrice() {
        return  Price;
    }
}
