package com.epam.javatrainings.pizza;

public class DoOrder {

    private static int globalOrderNumber = 10000;

    public static void main(String[] args) {

        PizzaBasket basket = new PizzaBasket(1234);

        Pizza pizza1 = new Calzone(basket.orderNumber());
        pizza1.setName("Pizza-1");
        pizza1.setQuantity(3);
        pizza1.addIngredient(Ingredient.BACON);
        pizza1.addIngredient(Ingredient.CHEESE);

        Pizza pizza2 = new RegularPizza(basket.orderNumber());
        pizza2.setName("Pizza-2");
        pizza2.setQuantity(2);
        pizza2.addIngredient(Ingredient.GARLIC);
        pizza2.addIngredient(Ingredient.SALAMI);
        pizza2.addIngredient(Ingredient.TOMATO_PASTE);

        basket.addPizza(pizza1);
        basket.addPizza(pizza2);


        System.out.println("Total price for order -> N" + basket.orderNumber() + " is : " + basket.calculateTotalPrice() + " $");
    }

    public static int getGlobalOrderNumber() {
        if(globalOrderNumber==100000){
            globalOrderNumber = 10000; //reset to minimal 5 digit number
        }
        return globalOrderNumber++;
    }
}
