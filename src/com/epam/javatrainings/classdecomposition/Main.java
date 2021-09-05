package com.epam.javatrainings.classdecomposition;

import com.epam.javatrainings.classdecomposition.palmetto.Customer;
import com.epam.javatrainings.classdecomposition.palmetto.Order;
import com.epam.javatrainings.classdecomposition.palmetto.Pizza;
import com.epam.javatrainings.classdecomposition.palmetto.enums.Ingredient;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Order order = new Order();
        Pizza pizza = new Pizza(List.of(new Customer("Erik")), List.of(order), "Americano", 5, 2);
        order.setPizza(List.of(pizza));
        System.out.println(order.getPizza());

        pizza.addIngredient(Set.of(Ingredient.CHEESE, Ingredient.BACON));
        System.out.println(pizza.getIngredient());

        Order order1 = new Order();
        Pizza pizza1 = new Pizza(List.of(new Customer("Anahit")), List.of(order1), "A", 6, 1);
        order1.setPizza(List.of(pizza1));
        System.out.println(order1.getPizza());
        //test name length()
        pizza1.setName("AB");
        System.out.println(pizza1.getName());
        pizza1.setName("ABCDE");

    }
}
