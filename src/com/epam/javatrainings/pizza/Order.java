package com.epam.javatrainings.pizza;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Customer customer;
    private List<Pizza> pizzas;
    private LocalDateTime created;
    private int number;

    public Order(final Customer customer,
                 final List<Pizza> pizzas,
                 final OrderNumberGenerator orderNumber) {
        this.number = orderNumber.generate();
        this.customer = customer;
        this.pizzas = pizzas;
        this.created = LocalDateTime.now();
    }

    public double getPrice() {
        double totalPrice = 0.0;
        for (Pizza pizza : pizzas) {
            double pizzaPrice = pizza.getType().getBasePrice();
            for (Ingredient ingredient : pizza.getIngredients()) {
                pizzaPrice += ingredient.getPrice();
            }
            pizzaPrice *= pizza.getQuantity();
            totalPrice += pizzaPrice;
        }
        return totalPrice;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public int getNumber() {
        return number;
    }

}