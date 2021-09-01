package com.epam.javatrainings.pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaBasket {

    private static int globalOrderNumber = 10000;

    private List<Pizza> pizzas;
    private final Customer customer;
    private final int orderNumber;

    public PizzaBasket(Customer customer) {
        pizzas = new ArrayList<>();
        this.orderNumber = globalOrderNumber++;
        this.customer = customer;
    }

    public void addPizza(Pizza pizza) {
        assert pizzas.size() < 10 : "You can add max 10 pizzas";
        pizza.setOrderNumber(orderNumber);
        pizzas.add(pizza);
    }

    public void printCheck() {
        System.out.println("********************************");
        System.out.println("Order : " + orderNumber);
        System.out.println("Client : " + customer.getCustomerNumber() + " " + customer.getName());
        for (Pizza pizza : pizzas) {
            System.out.println("Name : " + pizza.getName());
            System.out.println("--------------------------------");
            System.out.println("Pizza base : " + pizza.toString() + " " + pizza.getBasePrice() + " $");
            for (Ingredient ingredient : pizza.getIngredients()) {
                System.out.println(ingredient + " " + ingredient.getCost() + " $");
            }
            System.out.println("--------------------------------");
            System.out.println("Amount : " + pizza.calculatePrice() + " $");
            System.out.println("Quantity : " + pizza.getQuantity());
            System.out.println();
        }
        System.out.println("--------------------------------");
        System.out.println("Total amount : " + calculateTotalPrice() + " $");
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
