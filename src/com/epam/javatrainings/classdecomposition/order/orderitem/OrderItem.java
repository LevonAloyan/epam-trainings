package com.epam.javatrainings.classdecomposition.order.orderitem;

import com.epam.javatrainings.classdecomposition.pizza.Pizza;
import com.epam.javatrainings.classdecomposition.ingredient.Ingredient;

import java.util.Objects;
import java.math.BigDecimal;

public final class OrderItem {
    private final Pizza pizza;
    private final int quantity;
    private final QuantityUnit quantityUnit;
    private final BigDecimal unitPrice;
    private int index;

    private OrderItem(OrderItemBuilder builder) {
        this.pizza = builder.pizza;
        this.quantity = builder.quantity;
        this.unitPrice = builder.unitPrice;
        this.quantityUnit = builder.quantityUnit;
    }

    public OrderItem(OrderItem orderItem) {
        this.pizza = orderItem.getPizza();
        this.quantity = orderItem.quantity;
        this.quantityUnit = orderItem.quantityUnit;
        this.unitPrice = orderItem.unitPrice;
        this.index = orderItem.index;
    }

    public Pizza getPizza() {
        return new Pizza(pizza);
    }

    public int getQuantity() {
        return quantity;
    }

    public QuantityUnit getQuantityUnit() {
        return quantityUnit;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void updateIndex(int index) {
        this.index = index;
    }

    public void updatePizzaName(String validPizzaName) {
        pizza.updateName(validPizzaName);
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
        private final QuantityUnit quantityUnit;
        private final BigDecimal unitPrice;

        public OrderItemBuilder(Pizza pizza, int quantity, QuantityUnit quantityUnit) {
            this.pizza = new Pizza(pizza);
            this.quantity = quantity;
            this.quantityUnit = quantityUnit;
            this.unitPrice = calculateUnitPrice();
        }

        private BigDecimal calculateUnitPrice() {
            BigDecimal basePrice = pizza.getType().price;
            BigDecimal ingredientsPrice = new BigDecimal("0");

            for (Ingredient i : pizza.getIngredients()) {
                ingredientsPrice = ingredientsPrice.add(i.getPrice());
            }
            BigDecimal res = basePrice.add(ingredientsPrice); // whole pizza price
            if (QuantityUnit.SLICE.equals(quantityUnit)) {
                // slice price
                res = res.divide(new BigDecimal(Pizza.SLICE_COUNT), 2, BigDecimal.ROUND_HALF_UP);
            }
            return res;
        }

        public OrderItem build() {
            OrderItemValidator v = new OrderItemValidator();
            if (!v.validate(new Pizza(pizza), quantity, quantityUnit)) {
                throw new IllegalArgumentException("Failed to create an OrderItem with given args.");
            }
            return new OrderItem(this);
        }

    }

}
