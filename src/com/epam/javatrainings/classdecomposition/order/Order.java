package com.epam.javatrainings.classdecomposition;

public class Order {
    private int orderNumber = 10000;

    private int quantity = 0;

    public void order() {
        System.out.println("Order number:" + orderNumber +
                "\nCustomer number: " + Customer.getCustomerNumber() +
                "\nPizza name: " + Pizza.getPizzaname() +
                "\nQuantity: " + quantity);
    }

    public int getOrderNumber() {
        return orderNumber;
    }
}
