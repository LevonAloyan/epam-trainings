package com.epam.javatrainings.classdecomposition;

public class Main {
    public static void main(String[] args) {
        // Create customers
        Customer customer1 = new Customer(7717, "Kirk");
        Customer customer2 = new Customer(4372, "Cisco");

        // Create order objects associated with customers
        Order order1 = new Order(customer1);
        Order order2 = new Order(customer2);

        Pizza pizzaTmp;

        // Add the first pizza for the customer 1
        pizzaTmp = order1.addOrderItem(Helper.validatePizzaName("Margarita", order1), Pizza.TYPE_CALZONE, 2);
        pizzaTmp.addIngredient("ddd"); // invalid item, will not be added to the pizza
        pizzaTmp.addIngredient("Tomato paste");
        pizzaTmp.addIngredient("Tomato paste"); // Test adding duplicate ingredient
        pizzaTmp.addIngredient("Pepperoni");
        pizzaTmp.addIngredient("Garlic");
        pizzaTmp.addIngredient("Bacon");
        // System.out.println("Pizza Ingredients: " + pizzaTmp.getIngredients());
        // System.out.print("Pizza added to the order - ");
        // Helper.displayAttributes(pizzaTmp, order1);

        // Add the second pizza for the customer 1
        pizzaTmp = order1.addOrderItem(Helper.validatePizzaName("PepperoniOro", order1), Pizza.TYPE_REGULAR, 3); // The name of pizza will be overidden, as it is too short
        pizzaTmp.addIngredient("Tomato paste");
        pizzaTmp.addIngredient("Cheese");
        pizzaTmp.addIngredient("Salami");
        pizzaTmp.addIngredient("Olives");

        System.out.println("");
        Helper.printCheck(order1);

        // Add the first pizza for the customer 1
        pizzaTmp = order2.addOrderItem(Helper.validatePizzaName("BasePZZ", order2), Pizza.TYPE_REGULAR, 12);
        pizzaTmp.addIngredient("Cheese");
        pizzaTmp.addIngredient("Garlic");
        pizzaTmp.addIngredient("Bacon");

        System.out.println("");
        Helper.printCheck(order2);
    }
}
