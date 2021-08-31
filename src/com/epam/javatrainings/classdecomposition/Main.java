package com.epam.javatrainings.classdecomposition;

public class Main {
    public static void main(String[] args) {
        // Create customer objects
        Customer c1 = new Customer(234, "Kirk");
        Customer c2 = new Customer(67, "Cisco");

        // Create order objects associated with customers
        Order o1 = new Order(c1);
        Order o2 = new Order(c2);

        Pizza pizzaTmp;

        // Add the first pizza for customer 1
        pizzaTmp = o1.addOrderItem(Helper.validatePizzaName("Margarita", o1), Pizza.TYPE_REGULAR, 2);
        pizzaTmp.addIngredient("ddd"); // invalid item, will not be added to the pizza
        pizzaTmp.addIngredient("Cheese");
        pizzaTmp.addIngredient("Bacon");
        pizzaTmp.addIngredient("Garlic");
        System.out.println("Pizza Ingredients: " + pizzaTmp.getIngredients());
        System.out.print("Pizza added to the order - ");
        Helper.displayAttributes(pizzaTmp, o1);
        // System.out.println("Total cost : " + o1.cost() + " $"); // order is not completed yet
        System.out.println("");

        // Add the second pizza for customer 1
        pizzaTmp = o1.addOrderItem(Helper.validatePizzaName("Pi", o1), Pizza.TYPE_CALZONE, 5); // The name of pizza will be overidden, as it is too short
        pizzaTmp.addIngredient("Tomato paste");
        pizzaTmp.addIngredient("Olives");
        System.out.println("Pizza Ingredients: " + pizzaTmp.getIngredients());
        System.out.print("Pizza added to the order - ");
        Helper.displayAttributes(pizzaTmp, o1);
        System.out.println("Total cost : " + o1.cost() + " $");

        // Add the first pizza for customer 2
        pizzaTmp = o2.addOrderItem(Helper.validatePizzaName("Yerevan", o1), Pizza.TYPE_CALZONE, 1);
        pizzaTmp.addIngredient("Pepperoni");
        pizzaTmp.addIngredient("Corn");
        pizzaTmp.addIngredient("Bacon");
        System.out.println("Pizza Ingredients: " + pizzaTmp.getIngredients());
        System.out.print("Pizza added to the order - ");
        Helper.displayAttributes(pizzaTmp, o2);
        System.out.println("Total cost : " + o2.cost() + " $");
        System.out.println("");
    }
}
