package com.epam.javatrainings.classdecomposition.model;

import com.epam.javatrainings.classdecomposition.model.service.PizzaService;

import java.util.ArrayList;
import java.util.List;

public class Order{

    public static int numberOfOrder = 10000;
    private int numberOfCustomer;
    private List<Pizza> pizzaList;
    private double account;
    private Customer customer;

    public Order(int numberOfOrder, List<Pizza> pizzaList, Customer customer) {
        if (numberOfOrder == 100000) {
            this.numberOfOrder = 10000;
        } else {
            this.numberOfOrder++;
        }
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(PizzaService.createPizza());
        this.pizzaList = pizzas;



        for (Pizza pizza : pizzaList) {
            this.account += pizza.getPrice();
        }
        this.numberOfCustomer = Customer.getCustomerNumber();
    }


    public Order(){}

    public static int getNumberOfOrder() {
        return numberOfOrder;
    }

    public static void setNumberOfOrder(int numberOfOrder) {
        Order.numberOfOrder = numberOfOrder;
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

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "numberOfCustomer=" + numberOfCustomer +
                ", pizzaList=" + pizzaList +
                ", account=" + account +
                ", customer=" + customer +
                '}';
    }
}
