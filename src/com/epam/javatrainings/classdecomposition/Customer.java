package com.epam.javatrainings.classdecomposition;

import java.util.Scanner;

public class Customer {
    private static String customerName;
    private static int customerNumber = 0;

    public Customer(Scanner scanner) {
        System.out.print("Enter customer name: ");
        customerName = scanner.nextLine();
        customerNumber++;
        System.out.println("Customer number: " + customerNumber);
    }

    public static String getCustomerName() {
        return customerName;
    }
}
