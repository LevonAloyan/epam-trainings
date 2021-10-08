package com.epam.javatrainings.classdecomposition.model;

import com.epam.javatrainings.classdecomposition.util.OrderUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hayk on 02.09.2021.
 */
public class Order {
    private int number;
    private List<Pizza> pizzaList;
    private int customerNumber;
    private LocalDate date;

    public Order(int customerNumber) {
        this.customerNumber = customerNumber;
        this.number = OrderUtil.generateOrderNumber();
        this.date = LocalDate.now();
        this.pizzaList = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void addPizza(Pizza pizza) {
        this.pizzaList.add(pizza);
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public LocalDate getDate() {
        return date;
    }

}
