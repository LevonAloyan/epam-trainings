package com.epam.javatrainings.classdecomposition;

import java.time.LocalTime;
import java.util.Random;

public class Order {
    Random random = new Random();
    LocalTime orderTime;
    Customer customer;
    Pizza pizza = new Pizza();
    private final int orderNumber = 10000 + random.nextInt(89999);

    private int orderQuantity = 0;

    private double pizzaPrice = 0.0;
    private int pieceCount;

    private double getPrice() {
        Pizza.Ingredients.addIngredients("PEPPERONI");
        for (Pizza.Ingredients ingredients : Pizza.Ingredients.values()) {
            if (Pizza.PizzaType.valueOf("REGULAR") == Pizza.PizzaType.REGULAR) {
                pizzaPrice = ingredients.getIngredientsPrice() + Pizza.PizzaType.REGULAR.getBasePrice();
            } else {
                pizzaPrice = ingredients.getIngredientsPrice() + Pizza.PizzaType.CALZONE.getBasePrice();
            }
        }
        return pizzaPrice;
    }

    public void orderPizza() {
        customer = new Customer();
        orderTime = LocalTime.now();
        pizza.choosePizzaName("Margarita");
        System.out.println("Order time: " + orderTime);
        System.out.println("Order number: " + orderNumber);
        System.out.println("Order price: " + getPrice());
        System.out.println("Piece count: " + pieceCount);
    }
}
