package com.epam.javatrainings.classdecomposition.order.orderitem;


import com.epam.javatrainings.classdecomposition.pizza.Pizza;

public class OrderItemValidator {

    boolean isValidQuantity(int quantity) {
        return quantity >= 1 && quantity <= 10;
    }

    boolean isValidPizza(Pizza p) {
        return p != null;
    }

    boolean validate(Pizza p, int q) {
        return isValidQuantity(q) && isValidPizza(p);
    }
}
