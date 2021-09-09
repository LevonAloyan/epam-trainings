package com.epam.javatrainings.pizza;

public class OrderPrinterImpl implements OrderPrinter {
    @Override
    public void checkPrint(Order order) {
        order.orderPizza();
    }
}
