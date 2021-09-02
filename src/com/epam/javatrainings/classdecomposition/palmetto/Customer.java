package com.epam.javatrainings.classdecomposition.palmetto;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Customer {
    private static String name;
//    private String name;
    private static int customerNumber;
    private static final List<Integer> collectionOfCustomerNumber;

    static {
        collectionOfCustomerNumber = new LinkedList<>();
    }

    public Customer(String name) {
        Customer.name = name;
        generateCustomerNumber();
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        Customer.name = name;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    //Generate 4-digit unique random numbers
    public static void generateCustomerNumber() {
        Random random = new Random();
        //generate number between range nextInt(max + 1 - min) + min
        int randomNumber = random.nextInt(9999 + 1 - 1000) + 1000;
        if (collectionOfCustomerNumber.contains(randomNumber))
            generateCustomerNumber();
        customerNumber = randomNumber;
        collectionOfCustomerNumber.add(randomNumber);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", customerNumber=" + getCustomerNumber() +
                '}';
    }

}
