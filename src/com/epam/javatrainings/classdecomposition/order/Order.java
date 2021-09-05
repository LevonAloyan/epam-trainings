package com.epam.javatrainings.classdecomposition.order;

import com.epam.javatrainings.classdecomposition.pizza.Pizza;
import com.epam.javatrainings.classdecomposition.customer.Customer;
import com.epam.javatrainings.classdecomposition.order.orderitem.OrderItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public final class Order {
    public static final int MAX_PIZZA_COUNT_IN_ORDER = 10;
    private static int initialOrderNumber = 9999;
    private final int orderNumber;
    private final Customer customer;
    private final List<OrderItem> orderItems;
    private final BigDecimal totalAmount;

    private Order(OrderBuilder orderBuilder) {
        this.customer = orderBuilder.customer;
        this.orderItems = orderBuilder.orderItems;
        this.totalAmount = orderBuilder.totalAmount;
        orderNumber = ++initialOrderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getOrderItems() {
        return copyOrderItems(orderItems);
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    private static List<OrderItem> copyOrderItems(List<OrderItem> orderItems) {
        List<OrderItem> copy = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            OrderItem c = new OrderItem(orderItem);
            copy.add(c);
        }
        return copy;
    }


    public static final class OrderBuilder {
        private final Customer customer;
        private final List<OrderItem> orderItems;
        private final BigDecimal totalAmount;

        public OrderBuilder(Customer customer, List<OrderItem> orderItems) {
            this.customer = customer;
            this.orderItems = copyOrderItems(orderItems);
            this.totalAmount = calculateTotalAmount();
        }

        public OrderBuilder(Customer customer, OrderItem orderItem) {
            this(customer, new ArrayList<>(Arrays.asList(new OrderItem(orderItem))));
        }

        private BigDecimal calculateTotalAmount() {
            BigDecimal totalAmount = new BigDecimal(0);
            for (OrderItem i : orderItems) {
                BigDecimal orderItemTotalAmount = i.getAmount().multiply(new BigDecimal(i.getQuantity()));
                totalAmount = totalAmount.add(orderItemTotalAmount);
            }
            return totalAmount;
        }

        public Order build() {
            OrderValidator validator = new OrderValidator();
            if (!validator.isValidTotalQuantity(copyOrderItems(orderItems))) {
                throw new IllegalArgumentException("Failed to create an Order with given args.");
            }

            for (int i = 0; i < orderItems.size(); i++) {
                OrderItem orderItem = orderItems.get(i);
                //reassign index
                orderItem.updateIndex(i);
                //update pizza name if it is invalid
                Pizza pizza = orderItem.getPizza();
                if (!pizza.isValidName()) {
                    String newName = customer.getName().concat("_").concat(Integer.toString(i));
                    orderItem.updatePizzaName(newName);
                }
            }

            return new Order(this);
        }

    }

}
