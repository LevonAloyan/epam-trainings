package com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services;

import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.Pizza;
import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.PlacingAnOrder;

public class PizzaService {
    public static void printAttributes(Pizza pizza, PlacingAnOrder order){
         System.out.println("[" + order.getOrderNumber() +
                ":" + order.getCustomer().getNumberCustomer() +
                ":" + pizza.getName() +
                ":" + pizza.getQuantity() + "]");
    }
}
