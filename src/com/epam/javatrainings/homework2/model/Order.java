package com.epam.javatrainings.homework2.model;

import com.epam.javatrainings.homework2.OrderUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public void printCheck() {
        String euro = "\u20ac";
        System.out.println("********************************");
        System.out.println("Order: " + number);
        System.out.println("Client: " + customerNumber);
        double amount = 0;
        for (Pizza pizza : pizzaList) {
            System.out.println("Name:" + pizza.getName());
            System.out.println("--------------------------------");
            System.out.printf("Pizza base(%d) %d %d", pizza.getType().name(), pizza.getBasePrice() + pizza.getType().getPriceOfType(), euro);
            for (Ingredient ingredient : pizza.getIngredients()) {
                System.out.printf("%d %d %d", ingredient., ingredient.getPrice(), euro);
            }
            pizza.calculatePrice();
            amount += pizza.getPrice();
            System.out.printf("Amount: %d %d", pizza.getPrice(), euro);
            System.out.printf("Quantity: %d", pizza.getQuantity());
            System.out.println("--------------------------------");
        }
        System.out.printf("Total amount: %d %d", amount, euro);
    }
}
