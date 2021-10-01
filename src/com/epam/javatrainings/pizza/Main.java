package com.epam.javatrainings.pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Anna Arakelyan");

        List<Pizza> pizzas = new ArrayList<>();

        IntStream.range(0, 10).forEach(i -> {
            String name = Pizza.pickPizzaName("Margarita", customer);

            Pizza pizza = new Pizza(name, i % 2 == 0 ? Type.CALZONE : Type.REGULAR);
            System.out.println("Base: " + pizza.getType());
            pizza.addIngredient("CHEESE");
            pizza.addIngredient("TOMATO_PASTE");
            pizza.addIngredient("SALAMI");

            pizzas.add(pizza);

            pizza.setQuantity(5);
            System.out.println("Quantity: " + pizza.getQuantity() + "\n");
        });

        Order order = new Order(customer, pizzas, new OrderNumberGeneratorImpl());

        OrderPrint orderPrint = new OrderPrintImpl();
        orderPrint.print(order);
    }
}