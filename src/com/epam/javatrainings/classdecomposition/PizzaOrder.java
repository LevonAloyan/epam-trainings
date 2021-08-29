package com.epam.javatrainings.classdecomposition;

import java.util.ArrayList;
import java.util.List;

public class PizzaOrder {

    public static void main(String[] args) {
        List <String> ingredients = new ArrayList<>();
        ingredients.add("Corn");
        ingredients.add("Olives");
        ingredients.add("Garlic");
        Order order = new Order("Tatev", "pizza1", "REGULAR", 2, ingredients);
        System.out.println(order.getOrderPrice());
        System.out.println(order);

        //case2 pizza name size < 4
        Order order1 = new Order("Anna", "p", "CALZONE", 1, ingredients);
        System.out.println(order1.getOrderPrice());
        System.out.println(order1);

    }
}
