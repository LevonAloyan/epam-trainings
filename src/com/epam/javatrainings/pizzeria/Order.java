package com.epam.javatrainings.pizzeria;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

public class Order {
    private final  int orderNumber;
    private int customerId;
    private List <Pizza> pizzas;
    private LocalTime orderDateTime;

    public Order (int customerId){
        this.orderDateTime = LocalTime.now();
        this.pizzas = new ArrayList<Pizza>();
        this.customerId = customerId;
        orderNumber = (int) ((Math.random() * (99999 - 10000)) + 10000);
    }

    public LocalTime getLocalDateTime(){
        return orderDateTime;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public double getOrderPrice(){
        double total = 0;
        for (Pizza p : pizzas){
            total += p.calculateTotal();
        }
        return total;
    }

    public void addPizza(Pizza p){
        pizzas.add(p);
    }

    public void printCheck(){
        System.out.println("********************************");
        System.out.println("Order:  " + orderNumber );
        System.out.println("Order DateTime:  " + orderDateTime );
        System.out.println("Client:  " + customerId );
        for (Pizza p : pizzas){
            System.out.println("Name:  " + p.getName() );
            System.out.println("----------------------");
            double basePrice = p.getType().equals(Type.Calzone) ? 1.5 : 1;
            System.out.println("Pizza Base (" + p.getType() + ')' + "   " + basePrice + '$');
            for (Ingredient i : p.getIngredients()){
                System.out.println(i.name + "  " + i.price + '$');
            }
            System.out.println("-----------------------------------");
            System.out.println("Amount:  " + p.calculatePrice());
            System.out.println("Quantity  " + p.getQuantity() );
            System.out.println("-----------------------------------");
        }
        System.out.println("Total amount:   " + getOrderPrice() );
        System.out.println("********************************");

    }

}
