package com.epam.javatrainings.pizzeria;

public class Customer {
    private int id;
    private String name;

    public Customer(String name){
        this.id = (int) ((Math.random() * (9999 - 1000)) + 1000);
        this.name = name;
    }

    public Customer(String name, int id){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
