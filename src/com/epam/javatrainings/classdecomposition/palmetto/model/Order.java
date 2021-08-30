package com.epam.javatrainings.classdecomposition.palmetto.model;

import java.util.HashMap;
import java.util.Objects;

public class Order {
    private static int uid=  9999;
    private int order_id;
    private int customer_id;
    private HashMap<Integer, Pizza> pizzaHashMap;
    private float finalCost=0;

    public Order(int customer_id) {
        this.customer_id = customer_id;
        this.order_id=++uid;
        System.out.println ("Order_id "+ order_id);
        pizzaHashMap= new HashMap<> ();
    }

    public void addPizza(Pizza pizza, int count){
        pizzaHashMap.put(count,pizza);
        finalCost+=pizza.getCost ()*count;
        System.out.println ("Final cost : " +finalCost);
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", customer_id=" + customer_id +
                ", pizzaHashMap=" + pizzaHashMap.values ().stream ().toString () +
                ", finalCost=" + finalCost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return order_id == order.order_id && customer_id == order.customer_id && Float.compare (order.finalCost, finalCost) == 0 && Objects.equals (pizzaHashMap, order.pizzaHashMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash (order_id, customer_id, pizzaHashMap, finalCost);
    }

    public static int getUid() {
        return uid;
    }

    public static void setUid(int uid) {
        Order.uid = uid;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public HashMap<Integer, Pizza> getPizzaHashMap() {
        return pizzaHashMap;
    }

    public float getFinalCost() {
        return finalCost;
    }
}
