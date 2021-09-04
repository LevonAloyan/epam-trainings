package com.epam.javatrainings.classdecomposition.model;

import com.epam.javatrainings.classdecomposition.model.enums.PizzaType;
import com.epam.javatrainings.classdecomposition.model.service.PizzaService;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static List<Pizza> availablePizzas = new ArrayList<>();
    public static void main(String[] args) {

        Customer customer = new Customer();

        Order order = new Order(Order.numberOfOrder, availablePizzas,customer);
        availablePizzas.add(new Pizza(PizzaService.setName(order), PizzaType.REGULAR, 3 , PizzaService.setIngredientList()));

        System.out.println(order);

    }
}
