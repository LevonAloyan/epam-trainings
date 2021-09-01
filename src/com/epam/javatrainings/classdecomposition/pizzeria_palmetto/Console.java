package com.epam.javatrainings.classdecomposition.pizzeria_palmetto;

public class Console {
    public static final String NAME_CUSTOMER_1 = "Margarita";
    public static final String NAME_CUSTOMER_2 = "Robert";
    public static final String NAME_PIZZA_2 = "PepperoniOro";
    public static final String NAME_PIZZA_1 = "Margarita";
    public static final String NAME_PIZZA_3 = "BasePZZ";
    public static final String TYPE_PIZZA_1 = "calzone";
    public static final String TYPE_PIZZA_2 = "regular";
    public static final int QUANTITY_PIZZA_1 = 2;
    public static final int QUANTITY_PIZZA_2 = 3;
    public static final int QUANTITY_PIZZA_3 = 12;
    public static final int CUSTOMER_NUMBER_1 = 7717;
    public static final int CUSTOMER_NUMBER_2 = 4372;

    public static void main(String[] args) {
        //Created customer1 and customer2 where they give  name and id number
        Customer customer1 = new Customer(NAME_CUSTOMER_1, CUSTOMER_NUMBER_1);
        Customer customer2 = new Customer(NAME_CUSTOMER_2, CUSTOMER_NUMBER_2);
        // Customer can create an order
        PlacingAnOrder placingAnOrder1 = new PlacingAnOrder(customer1);
        PlacingAnOrder placingAnOrder2 = new PlacingAnOrder(customer2);
        //Add  ingredient to pizza
        Pizza pizza = placingAnOrder1.create(NAME_PIZZA_1, TYPE_PIZZA_1, QUANTITY_PIZZA_1, placingAnOrder1);
        pizza.addIngredient("Tomato paste");
        pizza.addIngredient("Pepperoni");
        pizza.addIngredient("Garlic");
        pizza.addIngredient("Bacon");
        placingAnOrder1.create(NAME_PIZZA_2, TYPE_PIZZA_2, QUANTITY_PIZZA_2, placingAnOrder1);
        pizza.addIngredient("Tomato paste");
        pizza.addIngredient("Cheese");
        pizza.addIngredient("Pepperoni");
        pizza.addIngredient("Olives");
        PrintCheck.printCheck(placingAnOrder1);
        placingAnOrder2.create(NAME_PIZZA_3, TYPE_PIZZA_2, QUANTITY_PIZZA_3, placingAnOrder2);
        pizza.addIngredient("Tomato paste");
        pizza.addIngredient("Cheese");
        PrintCheck.printCheck(placingAnOrder2);

    }
}
