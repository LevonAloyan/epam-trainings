package com.epam.javatrainings.pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaBasket {

    private List<Pizza> pizzas;
    private final int customerNumber;
    private final int orderNumber;

    public PizzaBasket(int customerNumber) {
        pizzas = new ArrayList<>();
        this.orderNumber = DoOrder.getGlobalOrderNumber();
        this.customerNumber = customerNumber;
    }

    public void addPizza(Pizza pizza) {
        assert pizzas.size()<11 : "You can add max 10 pizzas";
        pizzas.add(pizza);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Pizza pizza : pizzas) {
            totalPrice += pizza.calculatePrice();
        }
        return totalPrice;
    }

    public int orderNumber() {
        return orderNumber;
    }
}
