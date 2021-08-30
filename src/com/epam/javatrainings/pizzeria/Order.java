package com.epam.javatrainings.pizzeria;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final  int orderNumber;
    private int customerId;
    private List <Pizza> pizzas;

    public Order (int customerId){
        this.pizzas = new ArrayList<Pizza>();
        this.customerId = customerId;
        orderNumber = (int) ((Math.random() * (99999 - 10000)) + 10000);
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public double orderPrice(){
        double total = 0;
        for (Pizza p : pizzas){
            total += p.calculateTotal();
        }
        return total;
    }

    public void addPizza(Pizza p){
        pizzas.add(p);
    }

}
