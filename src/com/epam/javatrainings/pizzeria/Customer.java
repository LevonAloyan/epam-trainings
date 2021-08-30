package com.epam.javatrainings.pizzeria;

public class Customer {
    public int id;
    public String name;

    public Customer(String name){
        this.id = (int) ((Math.random() * (9999 - 1000)) + 1000);
        this.name = name;
    }
}
