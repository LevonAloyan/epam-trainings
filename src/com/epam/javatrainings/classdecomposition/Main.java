package com.epam.javatrainings.classdecomposition;

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order();
        Order order = new Order();

        System.out.println("Welcome to pizzeria 'PALMETTO'\n");

        Printer printer = new Printer();
        printer.checkPrint(order1);

        System.out.println();

        printer.checkPrint(order);
    }
}
