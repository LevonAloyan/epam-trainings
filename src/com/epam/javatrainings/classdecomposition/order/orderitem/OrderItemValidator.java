package com.epam.javatrainings.classdecomposition.order.orderitem;


import com.epam.javatrainings.classdecomposition.pizza.Pizza;

public class OrderItemValidator {

    boolean isValidQuantity(int quantity, QuantityUnit qUnit) {
        return quantity > 0 && quantity <= qUnit.maxCount;
    }

    boolean isValidPizza(Pizza p) {
        return p != null;
    }

    boolean validate(Pizza p, int q, QuantityUnit qUnit) {
        return isValidQuantity(q, qUnit) && isValidPizza(p);
    }
}
