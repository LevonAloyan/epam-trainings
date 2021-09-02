package com.epam.javatrainings.classdecomposition.order;

public class OrderValidator {

    static void validateOrder(Order order) {
        int totalQuantity = 0;
        for (OrderItem orderItem : order.getOrderItems()) {
            totalQuantity += orderItem.getQuantity();

            //update item name if it is invalid
            if (!orderItem.getPizza().isValidName()) {
                String validName = order.getCustomer().getName() + "_" + orderItem.getOrderIndex();
                orderItem.getPizza().setName(validName);
            }
        }
        if (totalQuantity > Order.MAX_ITEMS_COUNT_IN_ORDER) {
            throw new IllegalArgumentException("Failed to create an Order with given parameters.");
        }

    }

}
