package com.epam.javatrainings.classdecomposition;

public class Order {
    private PizzaBuilder.Pizza pizza;
    private long orderingNumber;

    public Order(PizzaBuilder.Pizza pizza, long orderingNumber) {
        this.pizza = pizza;
        this.orderingNumber = orderingNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "pizza=" + pizza +
                ", orderingNumber=" + orderingNumber +
                '}';
    }
}
