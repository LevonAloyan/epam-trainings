package com.epam.javatrainings.classdecomposition.order;

import com.epam.javatrainings.classdecomposition.ingredient.Ingredient;
import com.epam.javatrainings.classdecomposition.order.orderitem.OrderItem;

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

    public static void printCheck(Order order) {
        StringBuilder res = new StringBuilder("********************************");
        res
                .append("\nOrder: ")
                .append(order.getOrderNumber())
                .append("\nClient: ")
                .append(order.getCustomer().getCustomerId());
        for (OrderItem orderItem : order.getOrderItems()) {
            res
                    .append("\nName: ")
                    .append(orderItem.getPizza().getName())
                    .append("\n")
                    .append("--------------------------------")
                    .append("\n")
                    .append(orderItem.getPizza().describe())
                    .append("\n");
            for (Ingredient ingredient : orderItem.getPizza().getIngredients()) {
                res
                        .append(ingredient.describe())
                        .append("\n");
            }
            res
                    .append("--------------------------------")
                    .append("\nAmount: ")
                    .append(orderItem.getUnitPrice())
                    .append(" €\nQuantity: ")
                    .append(orderItem.getQuantity())
                    .append("\n")
                    .append("--------------------------------");
        }
        res
                .append("\nTotal amount: ")
                .append(order.getTotalAmount())
                .append(" €\n")
                .append("********************************");

        System.out.println(res);
    }

}
