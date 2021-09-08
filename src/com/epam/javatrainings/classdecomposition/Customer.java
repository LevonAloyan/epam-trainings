package com.epam.javatrainings.classdecomposition;

public class Customer {
    private static int customerNumber = 0;

    public static String getCustomerName() {
        return customerName;
    }

    private static String customerName;

    public Customer() {
        customerNumber++;
        System.out.println("Customer number: " + customerNumber);
    }
}
