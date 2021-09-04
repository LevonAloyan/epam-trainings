package com.company;

//Pizzeria "Palmetto" allows its customers to choose the ingredients when ordering pizza.
//        Each pizza ordered has an automatically assigned, non-changeable five-digit order number that is automatically saved.
//        Pizza can be of two types: regular and closed (Calzone). Customers can also give a name to your pizza and order up to 10 of them.
//        Currently, it is possible to use 7 different ingredients for making pizza (the table shows the price):
//
//        Tomato paste 1 $
//        Cheese	     1 $
//        Salami	     1.5 $
//        Bacon	     1.2 $
//        Garlic	     0.3 $
//        Corn	     0.7 $
//        Pepperoni	 0.6 $
//        Olives	     0.5 $
//
//        A pizza base costs 1 $, and + 0.5$ for Calzone.
//        Part 1.
//        Implement a class for placing an order. It must include the order number (five-digit number), customer number,
//        a list of “Pizza” items, each of which is an object containing the name of the pizza, list of ingredients, type of pizza, and quantity.
//        Implement an appropriate constructor in which the ingredients are not specified yet.
//        Check that the name of the pizza contains at least 4 and no more than 20 Latin characters. If the specified name does not satisfy this condition,
//        the pizza is named "customer_name_n", where n is the index number of the pizza in the order.
//        Implement a method for displaying pizza attributes, in which data about pizza is displayed as follows: [Order: Customer: Name: Quantity]
//        For instance: [10001 : 7717: Margarita: 2]


public class PlacingOrder {

    private static int orderNumber;
    private static int customerNumber;
    private String pizzaType;
    private String pizzaName;
    private int quantity;

    public void orderInfo() {
        System.out.println("[ " + orderNumber + " : " + customerNumber + ": " + pizzaName + ": " + quantity + "]");
    }

    PlacingOrder(String pizzaType, String pizzaName, int quantity) {
       if (orderNumber <= 99999 ) {
           orderNumber++;
       } else {
           orderNumber = 0;
       }
        customerNumber++;
        this.pizzaType = pizzaType;
        if (pizzaName.length() < 20 && pizzaName.length() > 4) {
            this.pizzaName = pizzaName;
        } else {
            this.pizzaName = "customer_name_" + orderNumber;
        }
        this.quantity = quantity;
    }
}
