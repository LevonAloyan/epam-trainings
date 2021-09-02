package com.epam.javatrainings.classdecomposition.order;

public class OrderItemValidator {

    static boolean isValidOrderItem(OrderItem o) {
        int quantity = o.getQuantity();
        return quantity >= 1 && quantity <= 10;
    }
}
