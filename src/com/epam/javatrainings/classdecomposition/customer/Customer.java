package com.epam.javatrainings.classdecomposition.customer;

import com.epam.javatrainings.classdecomposition.pizza.Pizza;

import java.util.Scanner;

public class Customer {
    private static String customerName;
    private static int customerNumber = 0;

    public Customer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        customerName = scanner.nextLine();

        Pizza.pizzaName();
    }

    public static String getCustomerName() {
        return customerName;
    }

    public static int getCustomerNumber() {
        return customerNumber;
    }
}
