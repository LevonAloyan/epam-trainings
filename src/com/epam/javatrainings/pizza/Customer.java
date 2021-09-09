package com.epam.javatrainings.pizza;

public class Customer {
    private int number = 0;
    private static String name;

    public static String getName() {
        return name;
    }

    public Customer() {
        number++;
        System.out.println("Customer number: " + number);
    }
}
