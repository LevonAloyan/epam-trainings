package com.epam.javatrainings.pizza;

public class Pizza {
    private static int orderNumber = 10000;
    private static int customerNumber = 0;
    private String nameOfPizza;
    private int quantity;
    private float price;


    public Pizza() {
    }

    public Pizza(int quantity, String nameOfPizza) {
        this.nameOfPizza = nameOfPizza;
        orderNumber += 1;
        customerNumber += 1;
        this.quantity = quantity;
    }

    public Pizza(String nameOfPizza, float price) {
        this.nameOfPizza = nameOfPizza;
        this.price = price;
    }

    public static int getCustomerNumber() {
        return customerNumber;
    }

    public String getNameOfPizza() {
        return nameOfPizza;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        Pizza.orderNumber = orderNumber;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "[" +
                orderNumber + ": " + customerNumber + ": " + nameOfPizza + ": " + quantity +
                ']';
    }

}
