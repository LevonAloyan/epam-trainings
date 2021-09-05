package com.epam.javatrainings.classdecomposition;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private int quantity;
    private float orderCost;
    private final int orderNumber;
    private final int customerNumber;
    private final LocalDate orderTime;
    private Map<Pizza, Integer> pizzas;

    public Order(int orderSerialNumber, int customerSerialNumber) {
        this.quantity = 0;
        this.orderCost = 0;
        this.pizzas = new HashMap<>();
        this.orderTime = LocalDate.now();
        this.orderNumber = orderSerialNumber;
        this.customerNumber = customerSerialNumber;
    }

    public void setPizzas(Pizza pizza, Integer count) {
        setQuantity(count);
        this.pizzas.put(pizza, count);
        setOrderCost(pizza.getCost(), count);
    }

    private void setQuantity(int quantity) {
        if(this.quantity <= 10 - quantity) {
            this.quantity += quantity;
        }
    }

    private void setOrderCost(float cost, int count) {
        this.orderCost += cost * count;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getOrderCost() {
        return orderCost;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public LocalDate getOrderTime() {
        return orderTime;
    }

    public Map<Pizza, Integer> getPizzas() {
        return pizzas;
    }
}
