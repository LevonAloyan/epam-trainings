package com.epam.javatrainings.classdecomposition.order;

import com.epam.javatrainings.classdecomposition.pizza.Pizza;
import com.epam.javatrainings.classdecomposition.order.orderitem.OrderItem;
import com.epam.javatrainings.classdecomposition.order.orderitem.QuantityUnit;

import java.util.List;

public class OrderValidator {
    private static final int MAX_SLICE_COUNT_IN_ORDER = Order.MAX_PIZZA_COUNT_IN_ORDER * Pizza.SLICE_COUNT;

    boolean isValidTotalQuantity(List<OrderItem> orderItems) {
        int total = 0;
        for (OrderItem orderItem : orderItems) {
            QuantityUnit qu = orderItem.getQuantityUnit();
            if (QuantityUnit.WHOLE.equals(qu)) {
                total += orderItem.getQuantity() * Pizza.SLICE_COUNT;
                continue;
            }
            total += orderItem.getQuantity();
        }

        return total <= MAX_SLICE_COUNT_IN_ORDER;
    }

}
