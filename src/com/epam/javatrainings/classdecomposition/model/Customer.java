package com.epam.javatrainings.classdecomposition.model;

import java.util.Scanner;

public class Customer {
    private static int customerNumber = 1;
    private String name;

    public Customer() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Customer Name : ");
        this.name = scanner.nextLine();
        ++customerNumber;
    }

    public static int getCustomerNumber() {
        return customerNumber;
    }

    public static void setCustomerNumber(int customerNumber) {
        Customer.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }
}
