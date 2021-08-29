package com.epam.javatrainings.homework_2;
public class Order {

    // global variables
    private int orderNumber;

    private int indexNumber;

    private int customerNumber;

    private Pizza pizza;

    private String customerName;


    public Order(int orderNumber, int indexNumber, int customerNumber, Pizza pizza, String customerName) {
        this.orderNumber = orderNumber;
        this.indexNumber = indexNumber;
        this.customerNumber = customerNumber;
        this.pizza = pizza;
        this.customerName = customerName;
    }

    public void showDetails(int count, String pizzaName) {
        System.out.println("Order: " + orderNumber +
                " Customer: " + customerName + " Name: " + pizzaName + " quantity: " + count);

    }
}

