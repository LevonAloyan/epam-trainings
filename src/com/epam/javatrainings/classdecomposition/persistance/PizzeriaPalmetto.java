package com.epam.javatrainings.classdecomposition.persistance;

import java.time.LocalTime;
import java.util.List;
import java.util.Random;

public class PizzeriaPalmetto {
    private List<Pizza> pizzas;
    private int orderNumber;
    private int customerNumber;
    private LocalTime orderTime;

    public PizzeriaPalmetto(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public PizzeriaPalmetto() {
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public int getOrderNumber() {
        return generateOrderNumber();
    }

    public int generateOrderNumber(){
        Random random = new Random();
        this.orderNumber = 10000 + random.nextInt(89999);
        return this.orderNumber;
    }

    public int getCustomerNumber() {
        return generateCustomerNumber();
    }

    public int generateCustomerNumber(){
        Random random = new Random();
        this.customerNumber = 1000 + random.nextInt(8999);
        return this.customerNumber;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalTime orderTime) {
        this.orderTime = orderTime;
    }
}
