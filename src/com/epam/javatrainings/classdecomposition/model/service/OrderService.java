package com.epam.javatrainings.classdecomposition.model.service;

import com.epam.javatrainings.classdecomposition.model.Order;
import com.epam.javatrainings.classdecomposition.model.Pizza;

public class OrderService {

    public static void pizzaAttributes(Pizza pizza, Order order) {

        StringBuilder sb = new StringBuilder();
        String pizzaAttribute = sb.append("[ ")
                .append(order.getNumberOfOrder())
                .append(" : ")
                .append(order.getNumberOfCustomer())
                .append(" : ")
                .append(pizza.getPrice())
                .append(" : ")
                .append(pizza.getQuantity())
                .append(" ]").toString();

        System.out.println(pizzaAttribute);
    }

    public static void printOrderAttributes(Order order) {
        StringBuilder sb = new StringBuilder();
        sb.append("Number Of Customer : ")
                .append(order.getNumberOfCustomer())
                .append(" Number Of Order : ")
                .append(Order.numberOfOrder).toString();
        System.out.println(sb);
        for (Pizza pizza : order.getPizzaList()) {
            System.out.println(pizza);
        }
        System.out.println("Account : " + order.getAccount());
        System.out.println("Customer : " + order.getCustomer());
    }

}
