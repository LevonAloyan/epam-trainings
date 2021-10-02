package com.epam.javatrainings.classdecomposition;

import java.time.LocalTime;
import java.util.*;

import static java.lang.System.exit;

public class Order {

    private HashMap<Pizza, Integer> pizzaMap;
    private final int orderNumber;
    private String customerName;
    private LocalTime localTime;

    public Order(String customerName, HashMap<Pizza, Integer> pizzaMap) {
        verifyQuantity(pizzaMap);
        verifyType(pizzaMap);
        orderNumber = generateOrderNumber();
        this.pizzaMap = pizzaMap;
        this.customerName = customerName;
        verifyName(pizzaMap);
        localTime = LocalTime.now();
    }

    @Override
    public String toString() {
        String s = "[" + this.orderNumber + " : " + this.customerName + " ]";
        for (Map.Entry<Pizza, Integer> set : pizzaMap.entrySet()) {
            s += set.getKey().getName() + " : " + set.getValue() + " ,";
        }
        return s + " ]";
    }

    public void verifyQuantity(HashMap<Pizza, Integer> map) {
        for (Integer i : map.values())
            if (i <= 0 || i >= 10) {
                System.out.println("Please set a valid quantity - invalid order");
                exit(1);
            }
    }

    public void verifyType(HashMap<Pizza, Integer> map) {
        for (Pizza i : map.keySet()) {
            if (i.type != "REGULAR" && i.type != "CALZONE") {
                System.out.println("Wrong pizza type - invalid order");
                exit(1);
            }
        }
    }

    private int generateOrderNumber() {
        Random r = new Random(System.currentTimeMillis());
        return 10000 + r.nextInt(20000);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String verifyName(HashMap<Pizza, Integer> map) {
        for (Pizza i : map.keySet()) {
            if (i.getName().length() <= 4 || i.getName().length() >= 20) {
                String name = customerName + getOrderNumber();
                i.setName(name);
            }
        }
        return null;
    }

    public double getOrderPrice() {
        double price = 0;
        for (Map.Entry<Pizza, Integer> set : pizzaMap.entrySet()) {
            price += set.getKey().getCost() * set.getValue();
        }
        return price;
    }

    public void printCheck(){
        System.out.println("Order "+ getOrderNumber() +"\n"
                +"Client " + customerName + "\n");
        for (Map.Entry<Pizza, Integer> set : pizzaMap.entrySet()){
            System.out.println(set.getKey().getName() + "\n"
            + "Pizza Base " + set.getKey().getBase()+ "\n"
            + "Quantity " + set.getValue() + "\n"
            + set.getKey().getIngredients() +  "\n"
            + "Amount " + getOrderPrice());
        }
    }

    public LocalTime getOrderTime(){
        return localTime;

    }}