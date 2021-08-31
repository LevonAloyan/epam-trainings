package com.epam.javatrainings.classdecomposition;

import java.util.Scanner;

public class Customer {
    private static String customerName;

    Customer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        customerName = scanner.nextLine();
    }

    public static String getCustomerName() {
        return customerName;
    }
}
