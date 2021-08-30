package com.epam.javatrainings.classdecomposition.palmetto.model;

import java.util.ArrayList;
import java.util.List;

public class Management {
    public List<Order> orders;

    public Management() {
        orders = new ArrayList<Order> ();
        printMenu ();
    }

    public void showOrders() {
        orders.stream ()
                .map (Order::getPizzaHashMap)
                .forEach(each -> each.values ().toString ())     ;
    }

    public float addOrder(Order order) {
        this.orders.add (order);
        return order.getFinalCost ();
    }

    public float addPizza(Order order,Pizza pizza, int count){
        order.getPizzaHashMap ().put(count,pizza);
        float fl= order.getFinalCost ()+ (pizza.getCost ()*count);
        System.out.println ("Final cost : " +fl);
        return fl;
    }


public Pizza createPizza(Customer customer,boolean calzone){
        Pizza pizza= new Pizza(customer.getName () + "_" +customer.getOrdered ().get (0), calzone);
        return pizza;
    }

    public Pizza createPizza(String name,boolean calzone){
        Pizza pizza= new Pizza(name, calzone);
        return pizza;
    }


    public Order createOrder(Customer customer){
        Order order = new Order(customer.getId ());
customer.getOrdered ().add(order.getOrder_id ());
        return order;
    }

    public void printMenu() {
        System.out.println (
                "      ...WELCOME...\n" +

                        "A pizza base costs 1 $    and 1.5$ for Calzone  \n"+

                        "Tomato paste\t     1 $\n" +
                        "Cheese      \t     1 $\n" +
                        "Salami      \t     1.5 $\n" +
                        "Bacon       \t     1.2 $\n" +
                        "Garlic      \t     0.3 $\n" +
                        "Corn        \t     0.7 $\n" +
                        "Pepperoni   \t     0.6 $\n" +
                        "Olives      \t     0.5 $");
    }

}
