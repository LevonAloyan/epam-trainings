package com.epam.javatrainings.classdecomposition.order;

public class OrderPrinter {

    public static void printOrderDescription(Order order) {
        StringBuilder res = new StringBuilder();
        for (OrderItem orderItem : order.getOrderItems()) {
            res
                    .append("\n[")
                    .append(order.getOrderNumber())
                    .append(": ")
                    .append(order.getCustomer().getCustomerId())
                    .append(": ")
                    .append(orderItem.getPizza().getName())
                    .append(": ")
                    .append(orderItem.getQuantity())
                    .append("]");
        }
        System.out.println(res);
    }
}
