package com.epam.javatrainings.classdecomposition.model;

/**
 * Created by Hayk on 30.09.2021.
 */
public final class PrintCheck {
    private PrintCheck(){}

    public void printCheck(Order order) {
        String euro = "\u20ac";
        System.out.println("********************************");
        System.out.println("Order: " + order.getNumber());
        System.out.println("Client: " + order.getCustomerNumber());
        double amount = 0;
        for (Pizza pizza : order.getPizzaList()) {
            System.out.println("Name:" + pizza.getName());
            System.out.println("--------------------------------");
            System.out.printf("Pizza base(%d) %d %d", pizza.getType().name(), pizza.getBasePrice() + pizza.getType().getPriceOfType(), euro);
            for (Ingredient ingredient : pizza.getIngredients()) {
                System.out.printf("%d %d %d", ingredient.name(), ingredient.getPrice(), euro);
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
