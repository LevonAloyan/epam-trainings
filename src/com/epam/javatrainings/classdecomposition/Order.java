package com.epam.javatrainings.classdecomposition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
    private final List<PizzaBuilder.Pizza> pizzaList = new ArrayList<>();
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

    public long getOrderingNumber() {
        return orderingNumber;
    }

}
