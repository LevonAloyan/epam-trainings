package com.epam.javatrainings.classdecomposition;

public class Order {
    private int orderNumber = 10000;
    private int customerNumber = 0;

    private int quantity = 0;

    Pizza pizza = new Pizza();

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

}
