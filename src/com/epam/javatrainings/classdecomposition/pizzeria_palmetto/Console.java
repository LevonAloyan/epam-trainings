package com.epam.javatrainings.classdecomposition.pizzeria_palmetto;

public class Console {
    public static final String NAME_CUSTOMER1 = "Margarita";
    public static final String NAME_CUSTOMER2 = "Robert";
    public static final String NAME_PIZZA = "Quin";
    public static final String TYPE_PIZZA1 = "calzone";
    public static final String TYPE_PIZZA2 = "regular";
    public static final int QUANTITY_PIZZA1 = 2;
    public static final int QUANTITY_PIZZA2 = 3;

    public static void main(String[] args) {
        //Create customer1 where she gives his name
        Customer customer1 = new Customer(NAME_CUSTOMER1);
        //Create customer2 where he gives his name and pizza name
        Customer customer2 = new Customer(NAME_CUSTOMER2, NAME_PIZZA);
        Customer customer3 = new Customer("Armen");
        // Customers can create an order
        PlacingAnOrder placingAnOrder1 = new PlacingAnOrder(customer1);
        PlacingAnOrder placingAnOrder2 = new PlacingAnOrder(customer2);
        placingAnOrder1.create(customer1, TYPE_PIZZA1, QUANTITY_PIZZA1);
        placingAnOrder2.create(customer2, TYPE_PIZZA2, QUANTITY_PIZZA2);
        //Displaying pizza attributes
        System.out.println(placingAnOrder1.getOrderItems());
        System.out.println(placingAnOrder2.getOrderItems());
        //They can add ingredients to pizza
        Ingredients.showIngredient();
        Pizza pizza1 = placingAnOrder1.getOrderItems().get(0);
        Pizza pizza2 = placingAnOrder2.getOrderItems().get(0);
        pizza1.addIngredient("Corn");
        pizza1.addIngredient("Olives");
        pizza2.addIngredient("Garlic");
        pizza2.addIngredient("Salami");
        //The amount to be paid
        System.out.println(pizza1.getCostPizza() + "$");
        System.out.println(pizza2.getCostPizza() + "$");
    }
}
