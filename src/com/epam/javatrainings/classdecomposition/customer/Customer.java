package com.epam.javatrainings.classdecomposition;

import java.util.Scanner;

public class Customer {
    private static String customerName;
    private static int customerNumber = 0;

    public static int getCustomerNumber() {
        return customerNumber;
    }

    Customer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        customerName = scanner.nextLine();
    }

    public static String getCustomerName() {
        return customerName;
    }
}
