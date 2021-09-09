package com.epam.javatrainings.pizza;

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order();
        Order order = new Order();

        System.out.println("Welcome to pizzeria 'PALMETTO'\n");

        OrderPrinterImpl printer = new OrderPrinterImpl();
        printer.checkPrint(order1);

        System.out.println();

        printer.checkPrint(order);
    }
}
