package com.epam.javatrainings.classdecomposition;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to pizzeria 'PALMETTO'");

        Customer customer = new Customer(scanner);
     /*   Customer customer1 = new Customer(scanner);*/

        Order order = new Order();

        order.orderPizza(customer);

        /*order.orderPizza(customer1);*/
    }
}
