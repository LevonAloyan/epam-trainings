package com.epam.javatrainings.classdecomposition.order.orderitem;

import com.epam.javatrainings.classdecomposition.ingredient.Ingredient;
import com.epam.javatrainings.classdecomposition.pizza.Pizza;

import java.math.BigDecimal;
import java.util.Objects;

public final class OrderItem {
    private final Pizza pizza;
    private final int quantity;
    private int index;
    private final BigDecimal amount;

    private OrderItem(OrderItemBuilder builder) {
        this.pizza = builder.pizza;
        this.quantity = builder.quantity;
        this.amount = builder.amount;
    }

    public OrderItem(OrderItem orderItem) {
        this.pizza = orderItem.getPizza();
        this.quantity = orderItem.quantity;
        this.index = orderItem.index;
        this.amount = orderItem.amount;
    }

    public Pizza getPizza() {
        return new Pizza(pizza);
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void updateIndex(int index) {
        this.index = index;
    }

    public void updatePizzaName(String validPizzaName) {
        pizza.updateName(pizza, validPizzaName);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "pizza=" + pizza +
                ", quantity=" + quantity +
                ", index=" + index +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return quantity == orderItem.quantity && index == orderItem.index && Objects.equals(pizza, orderItem.pizza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pizza, quantity, index);
    }

    public static class OrderItemBuilder {
        private final Pizza pizza;
        private final int quantity;
        private final BigDecimal amount;

        public OrderItemBuilder(Pizza pizza, int quantity) {
            this.pizza = new Pizza(pizza);
            this.quantity = quantity;
            this.amount = calculateAmount();
        }

        private BigDecimal calculateAmount() {
            BigDecimal price = pizza.getBasePrice();

            for (Ingredient i : pizza.getIngredients()) {
                price = price.add(i.getPrice());
            }
            return price;
        }

        public OrderItem build() {
            OrderItemValidator v = new OrderItemValidator();
            if (!v.validate(new Pizza(pizza), quantity)) {
                throw new IllegalArgumentException("Failed to create an OrderItem with given args.");
            }
            return new OrderItem(this);
        }

    }

}
