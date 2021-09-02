package com.epam.javatrainings.classdecomposition.order;

import com.epam.javatrainings.classdecomposition.customer.Customer;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Order {

    public static final int MAX_ITEMS_COUNT_IN_ORDER = 10;
    private int orderNumber;
    private final Customer customer;
    private final List<OrderItem> orderItems;

    private Order(OrderBuilder orderBuilder) {
        this.customer = orderBuilder.customer;
        this.orderItems = orderBuilder.orderItems;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    private void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public static class OrderBuilder {
        private final Customer customer;
        private final List<OrderItem> orderItems;
        private static int initialOrderNumber = 9999;

        public OrderBuilder(Customer customer, List<OrderItem> orderItems) {
            this.customer = customer;
            this.orderItems = orderItems;

        }

        public OrderBuilder(Customer customer, OrderItem orderItem) {
            this(customer, new ArrayList<>(Arrays.asList(orderItem)));
        }

        private Order reassignOrderItemOrderIndex(Order o) {
            List<OrderItem> orderItems = o.getOrderItems();
            for (int i = 0; i < o.getOrderItems().size(); i++) {
                OrderItem orderItem = orderItems.get(i);
                orderItem.setOrderIndex(i);
            }
            return o;
        }

        public Order build() {
            Order order = new Order(this);
            OrderValidator.validateOrder(order);
            order.setOrderNumber(++initialOrderNumber);
            return reassignOrderItemOrderIndex(order);
        }

    }


}
