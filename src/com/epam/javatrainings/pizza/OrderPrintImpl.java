package com.epam.javatrainings.pizza;

public class OrderPrintImpl implements OrderPrint {
    @Override
    public void print(Order order) {
        System.out.println("Order time: " + order.getCreated());
        System.out.println("Order number: "+order.getNumber());
        System.out.println("Order price: "+ order.getPrice());
    }
}
