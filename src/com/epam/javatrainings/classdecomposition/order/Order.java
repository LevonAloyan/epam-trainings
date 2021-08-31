package com.epam.javatrainings.classdecomposition.order;

import com.epam.javatrainings.classdecomposition.customer.Customer;
import com.epam.javatrainings.classdecomposition.pizza.Pizza;

public class Order {
    private static int orderNumber = 10000;
    private int quantity = 0;

    public void order() {
        System.out.println("Order number:" + (orderNumber++) +
                "\nCustomer number: " + Customer.getCustomerNumber() +
                "\nPizza name: " + Pizza.getPizzaname() +
                "\nQuantity: " + (quantity++));
    }

    public void pizzaQuantity(String name) {
        if (name.equals(Customer.getCustomerName())) {
            while (quantity < 10) {
                quantity++;
            }
            System.out.println(quantity);
        }
    }

    public static int getOrderNumber() {
        return orderNumber;
    }
}
