package com.epam.javatrainings.classdecomposition;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to pizzeria 'PALMETTO'\n");

        Customer customer = new Customer(scanner);

        Order order = new Order();

        order.orderPizza(customer);
    }
}
