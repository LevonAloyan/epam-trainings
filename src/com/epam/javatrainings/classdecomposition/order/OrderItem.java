package com.epam.javatrainings.classdecomposition.order;


import com.epam.javatrainings.classdecomposition.pizza.Pizza;

public class OrderItem {
    private final Pizza pizza;
    private final int quantity;
    private int orderIndex = -1; // -1 means that this orderItem isn't in any Order yet


    private OrderItem(OrderItemBuilder builder) {
        this.pizza = builder.pizza;
        this.quantity = builder.quantity;
    }

    Pizza getPizza() {
        return pizza;
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
                "pizza=" + pizza +
                ", quantity=" + quantity +
                ", orderIndex=" + orderIndex +
                '}';
    }

    public static class OrderItemBuilder {
        private final Pizza pizza;
        private final int quantity;

        public OrderItemBuilder(Pizza pizza, int quantity) {
            this.pizza = pizza;
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
