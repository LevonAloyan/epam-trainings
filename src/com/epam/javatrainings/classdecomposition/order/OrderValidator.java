package com.epam.javatrainings.classdecomposition.order;

import com.epam.javatrainings.classdecomposition.order.orderitem.OrderItem;

import java.util.List;

public class OrderValidator {

    boolean isValidTotalQuantity(List<OrderItem> orderItems) {
        int total = 0;
        for (OrderItem orderItem : orderItems) {
            total += orderItem.getQuantity();
        }
        return total <= Order.MAX_PIZZA_COUNT_IN_ORDER;
    }

}
