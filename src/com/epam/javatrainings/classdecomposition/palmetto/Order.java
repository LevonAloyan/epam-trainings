package com.epam.javatrainings.classdecomposition.palmetto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Order {
    private List<Pizza> pizza;
    private static int orderNumber;
    private static final List<Integer> collectionOfOrderNumber;
    private final LocalTime localTime;

    static {
        collectionOfOrderNumber = new LinkedList<>();
    }

    {
        this.localTime = LocalTime.now();
    }

    public Order() {
        generateOrderNumber();
        System.out.println("Order time is: " + localTime.format(DateTimeFormatter.ofPattern("h:mm")));
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

    //Generate 5-digit unique random numbers (UNIQ)
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
