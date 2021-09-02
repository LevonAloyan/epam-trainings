package com.epam.javatrainings.classdecomposition;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int initialOrderNumber = 10000;
    private static int initialCustomerNumber = 1;
    private int orderNumber;
    private int customerNumber;
    private List<Pizza> pizzaItems = new ArrayList<>();
    private Customer customer;
    private LocalTime time;

    public Order() {
        setOrderNumber(initialOrderNumber);
        this.customerNumber = initialCustomerNumber;
        initialOrderNumber++;
        initialCustomerNumber++;
    }

    public void placeOrder(Pizza pizza, Customer customer) {
        pizzaItems.add(pizza);
        pizza.setOrder(this);
        this.customer = customer;
        this.time = LocalTime.now();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        if(orderNumber >= 10000 && orderNumber <= 99999) {
            this.orderNumber = orderNumber;
        } else {
            throw new IndexOutOfBoundsException("Provided order number isn't valid");
        }
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public List<Pizza> getPizzaItems() {
        return pizzaItems;
    }

    public void setPizzaItems(List<Pizza> pizzaItems) {
        this.pizzaItems = pizzaItems;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }


    //Some utility methods
    public void checkout() {
        System.out.println("-----------------------------------------");
        List<Pizza> pizzas = getPizzaItems();
        for (Pizza p: pizzas) {
            p.displayPizzaAttributes();
        }
    }

    public void printTotalPrice() {
        double price = calculateTotalPrice();
        System.out.println("Total price for order #" + orderNumber + " - $" + price);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        List<Pizza> pizzas = getPizzaItems();
        for (Pizza p: pizzas) {
            for(int i = 0; i < p.getQuantity(); i++) {
                totalPrice += p.calculatePrice();
            }
        }
        return totalPrice;
    }

}

