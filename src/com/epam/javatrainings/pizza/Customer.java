package com.epam.javatrainings.pizza;

public class Customer {

    private static int number = 0;

    private String name;

    public Customer(String name) {
        this.name = name;
        number++;
        System.out.println("Customer number: " + number);
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
