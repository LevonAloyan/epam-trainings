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
        pizzaTmp = new Pizza(Validator.validatePizzaName("Margarita", order1), PizzaType.CALZONE, 2);
        pizzaTmp.addIngredient(Ingredient.TomatoPaste);
        pizzaTmp.addIngredient(Ingredient.TomatoPaste); // Test adding duplicate ingredient
        pizzaTmp.addIngredient(Ingredient.Pepperoni);
        pizzaTmp.addIngredient(Ingredient.Garlic);
        pizzaTmp.addIngredient(Ingredient.Bacon);
        order1.addOrderItem(pizzaTmp);

        // Add the second pizza for the customer 1
        pizzaTmp = new Pizza(Validator.validatePizzaName("PepperoniOro", order1), PizzaType.REGULAR, 3);
        pizzaTmp.addIngredient(Ingredient.TomatoPaste);
        pizzaTmp.addIngredient(Ingredient.Cheese);
        pizzaTmp.addIngredient(Ingredient.Salami);
        pizzaTmp.addIngredient(Ingredient.Olives);
        order1.addOrderItem(pizzaTmp);

        System.out.println("");
        Printer.printCheck(order1);
        System.out.println("");

        // Add a pizza for the customer 2
        pizzaTmp = new Pizza(Validator.validatePizzaName("BasePZZ", order2), PizzaType.REGULAR, 12);
        pizzaTmp.addIngredient(Ingredient.Cheese);
        pizzaTmp.addIngredient(Ingredient.Garlic);
        pizzaTmp.addIngredient(Ingredient.Bacon);
        order2.addOrderItem(pizzaTmp);

        System.out.println("");
        Printer.printCheck(order2);
    }
}
