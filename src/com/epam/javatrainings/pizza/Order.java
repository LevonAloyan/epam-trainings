package com.epam.javatrainings.pizza;

import java.time.LocalDateTime;

public class Order {

    /*Pizza pizza = new Pizza("Margarita",PizzaType.REGULAR, );*/
    Customer customer = new Customer();
    LocalDateTime time = LocalDateTime.now();

    private int orderQuantity = 0;
    private double pizzaPrice = 0.0;
    private int pieceCount;

    private double getPrice() {
      Pizza.addIngredients("PEPPERONI");
        for (Ingredients ingredients : Ingredients.values()) {
            if (PizzaType.valueOf("REGULAR") == PizzaType.REGULAR) {
                pizzaPrice = ingredients.getIngredientsPrice() + PizzaType.REGULAR.getBasePrice();
            } else {
                pizzaPrice = ingredients.getIngredientsPrice() + PizzaType.CALZONE.getBasePrice();
            }
        }
        return pizzaPrice;
    }

    public void orderPizza() {

        /*pizza.choosePizzaName("Margarita");*/
        System.out.println("Order time: " + time);
        System.out.println("Order number: ");
        System.out.println("Order price: " + getPrice());
        System.out.println("Piece count: " + pieceCount);
    }
}
