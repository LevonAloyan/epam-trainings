package com.epam.javatrainings.classdecomposition.model;

import java.util.List;

public class Order {

    private int numberOfOrder;
    private int numberOfCustomer;
    private List<Pizza> pizzaList;

    public Order(int numberOfOrder, int numberOfCustomer, List<Pizza> pizzaList) {
        this.numberOfOrder = numberOfOrder;
        this.numberOfCustomer = numberOfCustomer;
        this.pizzaList = pizzaList;
    }

    public void pizzaAttributes(Pizza pizza) {

        StringBuilder sb = new StringBuilder();
        String pizzaAttribute  = sb.append("[ ")
                .append(numberOfOrder)
                .append(" : ")
                .append(numberOfCustomer)
                .append(" : ")
                .append(pizza.getName())
                .append(" : ")
                .append(pizza.getQuantity())
                .append(" ]").toString();

        System.out.println(pizzaAttribute);
    }

    public int getNumberOfOrder() {
        return numberOfOrder;
    }

    public void setNumberOfOrder(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }

    public void setNumberOfCustomer(int numberOfCustomer) {
        this.numberOfCustomer = numberOfCustomer;
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }
}
