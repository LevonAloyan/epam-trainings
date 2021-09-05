package com.epam.javatrainings.classdecomposition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PizzaOrder {

    public static void main(String[] args) {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("Corn");
        ingredients.add("Olives");
        ingredients.add("Garlic");
        HashMap<Pizza, Integer> pizzaMap = new HashMap<>();
        pizzaMap.put(new Pizza("Pizza1", "REGULAR", ingredients), 2);
        Pizza p = new Pizza("p2", "CALZONE", ingredients);
        pizzaMap.put(p,1);

        Order order = new Order("Tatev", pizzaMap);
        order.printCheck();
        System.out.println(order.getOrderTime());


    }
}
