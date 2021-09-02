package com.epam.javatrainings.classdecomposition.palmetto;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Order {
    private List<Pizza> pizza;
    private static int orderNumber;
    private static final List<Integer> collectionOfOrderNumber;

    static {
        collectionOfOrderNumber = new LinkedList<>();
    }

    public Order() {
        generateOrderNumber();
    }

        public List<Pizza> getPizza() {
        return pizza;
    }

    public void setPizza(List<Pizza> pizza) {
        this.pizza = pizza;
    }

    public static int getOrderNumber() {
        return orderNumber;
    }

    //Generate 5-digit unique random numbers
    public static void generateOrderNumber() {
        Random random = new Random();
        //5-digit number generate nextInt(max + 1 - min) + min
        int randomNumber = random.nextInt(99999 + 1 - 10000) + 10000;
        if (collectionOfOrderNumber.contains(randomNumber))
            generateOrderNumber();
        orderNumber = randomNumber;
        collectionOfOrderNumber.add(randomNumber);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + getOrderNumber() +
                '}';
    }
}
