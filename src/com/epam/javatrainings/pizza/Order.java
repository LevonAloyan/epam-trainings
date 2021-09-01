package com.epam.javatrainings.pizza;

public class Order {

    public static void main(String[] args) {

        Customer customer_1 = new Customer("John Doe", 7544);

        PizzaBasket basket = new PizzaBasket(customer_1);

        Pizza margarita = new RegularPizza();
        margarita.setName("Margarita");
        margarita.setQuantity(3);
        margarita.addIngredient(Ingredient.BACON);
        margarita.addIngredient(Ingredient.TOMATO_PASTE);
        margarita.addIngredient(Ingredient.PEPPERONI);
        margarita.addIngredient(Ingredient.GARLIC);

        Pizza calzone = new Calzone();
        calzone.setName("Calzone");
        calzone.setQuantity(2);
        calzone.addIngredient(Ingredient.CHEESE);
        calzone.addIngredient(Ingredient.TOMATO_PASTE);
        calzone.addIngredient(Ingredient.SALAMI);
        calzone.addIngredient(Ingredient.OLIVES);

        basket.addPizza(margarita);
        basket.addPizza(calzone);

        basket.printCheck();

//        System.out.println("Total price for order -> N" + basket.orderNumber() + " is : " + basket.calculateTotalPrice() + " $");
    }

}
