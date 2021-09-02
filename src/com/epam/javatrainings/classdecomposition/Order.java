package com.epam.javatrainings.classdecomposition;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<PizzaBuilder.Pizza> pizzaList = new ArrayList<>();

    public long getOrderingNumber() {
        return orderingNumber;
    }

    private final long orderingNumber;

    public Order(long orderingNumber) {
        this.orderingNumber = orderingNumber;
    }

    public void addPizzaToPizzaList(PizzaBuilder.Pizza pizza) {
        if (pizza != null){
            pizzaList.add(pizza);
        }
    }

    public List<PizzaBuilder.Pizza> getPizzaList() {
        return pizzaList;
    }

    @Override
    public String toString() {
        return "Order{" + "\n" +
                "orderingNumber : " + orderingNumber + "\n" +
                "pizzaList=" + pizzaList + "\n" +
                '}';
    }
}
