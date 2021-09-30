package com.epam.javatrainings.classdecomposition.service;

public class PizzaService {
    public static String pizzasDefaultName(String customerName, int orderNumber, String pizzaName){
        if (pizzaName == null) {
            return customerName + "_" + orderNumber;
        }
        return pizzaName;
    }
}
