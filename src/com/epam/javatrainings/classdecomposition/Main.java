package com.epam.javatrainings.classdecomposition;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Order order = service.makeOrder();
//        Printer.print(order);
        Printer.printCheck(order);
    }
}
