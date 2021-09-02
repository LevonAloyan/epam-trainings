package com.epam.javatrainings.classdecomposition.order;

import com.epam.javatrainings.classdecomposition.item.Item;

public class OrderItem {
    private final Item item;
    private final int quantity;
    private int orderIndex = -1; // -1 means that this orderItem isn't in any Order yet


    private OrderItem(OrderItemBuilder builder) {
        this.item = builder.item;
        this.quantity = builder.quantity;
    }

    Item getItem() {
        return item;
    }

    int getOrderIndex() {
        return orderIndex;
    }

    void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "item=" + item +
                ", quantity=" + quantity +
                ", orderIndex=" + orderIndex +
                '}';
    }

    public static class OrderItemBuilder {
        private final Item item;
        private final int quantity;

        public OrderItemBuilder(Item item, int quantity) {
            this.item = item;
            this.quantity = quantity;
        }

        public OrderItem build() {
            OrderItem orderItem = new OrderItem(this);
            if (!OrderItemValidator.isValidOrderItem(orderItem)) {
                throw new IllegalArgumentException("Failed to create an OrderItem with given parameters.");
            }
            return orderItem;
        }

    }

}
