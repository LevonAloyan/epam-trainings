package com.epam.javatrainings.classdecomposition;

import java.util.List;
import java.util.Random;

import static java.lang.System.exit;

public class Order {

    private final int orderNumber;
    private Pizza pizza;
    private int quantity;
    private String customerName;

    public Order(String customerName, String pizzaName, String pizzaType, int quantity, List<String> ingredients){
        orderNumber = generateOrderNumber();
        pizzaName = setName(pizzaName, customerName);
        pizza = new Pizza(pizzaName, pizzaType, ingredients);
        this.setQuantity(quantity);
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "[" + this.orderNumber + " : " + this.customerName + " : " +  this.pizza.name + " : " + this.quantity + "]";
    }

    public String  getPizzaName(){
        return pizza.name;
    }

    public String getPizzaType(){
        return pizza.type;
    }

    public void setQuantity(int quantity){
        if (quantity <= 0 || quantity >=10){
            System.out.println("Please set a valid quantity - invalid order");
            exit(1);
        }
        this.quantity = quantity;
    }

    private int generateOrderNumber() {
        Random r = new Random( System.currentTimeMillis() );
        return 10000 + r.nextInt(20000);
    }

    public int getOrderNumber(){
        return orderNumber;
    }

    public String setName(String name, String customerName){
        if (! (name.length() >= 4 && name.length() <=20))
            name = customerName + getOrderNumber();
        return name;

    }

    public double getOrderPrice(){
        return quantity * pizza.getCost();
    }
}
