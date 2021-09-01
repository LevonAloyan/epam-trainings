package com.epam.javatrainings.classdecomposition.pizzeria_palmetto;

public class PrintCheck {

    static void printCheck(PlacingAnOrder placingAnOrder){
        System.out.println("********************************");
        System.out.println("Order: " + placingAnOrder.getOrderNumber());
        System.out.println("Client: " + placingAnOrder.getCustomer().getNumberCustomer());
        System.out.println("Time: " + placingAnOrder.getLocalTime());
        for (Pizza pizza : placingAnOrder.getOrderItems()) {
            System.out.println("Name: " + pizza.getName());
            System.out.println("--------------------------------");
            System.out.println("Pizza Base " + "(" + pizza.getType() + ")" + pizza.getType().getCost() + " €");

            for (String ingredient : Pizza.ingredientsList) {
                for (Ingredients ingredients : Ingredients.values()) {
                    if (ingredients.getKey().equals(ingredient)) {
                        System.out.println(ingredient + " " + ingredients.getCost());
                    }
                }
            }
            System.out.println("--------------------------------");
            System.out.println("Amount: " + pizza.getCostPizza() + " €");
            System.out.println("Quantity: " + pizza.getQuantity());
            System.out.println("--------------------------------");
        }
        System.out.println("Total amount: " + placingAnOrder.costOrder() + " €");
        System.out.println("********************************");
    }
}
