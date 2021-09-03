package com.epam.javatrainings.classdecomposition.service;

import com.epam.javatrainings.classdecomposition.persistance.Customer;
import com.epam.javatrainings.classdecomposition.persistance.Pizza;
import com.epam.javatrainings.classdecomposition.persistance.PizzeriaPalmetto;

import java.util.ArrayList;
import java.util.List;

public class PizzeriaPalmettoService {
    public static void displayingPizzaAtribute(int orderNumber, int customerNumber, String pizzaName, int quantity){
        System.out.println("[" + orderNumber + " : " + customerNumber + " : " + pizzaName + " : " + quantity + "]");
    }

    public static List<Pizza> addPizzas(Pizza pizza){
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(pizza);
        return pizzas;
    }

    public static void printCheck(PizzeriaPalmetto pizzeriaPalmetto, Customer customer){
        int orderNumber = pizzeriaPalmetto.generateOrderNumber();
        System.out.println("********************************");
        System.out.println("Order: " + orderNumber);
        System.out.println("Client: " + pizzeriaPalmetto.generateCustomerNumber());
        printPizzasInfo(pizzeriaPalmetto.getPizzas(),customer,orderNumber);
        System.out.println("********************************");
    }

    private static void printPizzasInfo(List<Pizza> pizzas, Customer customer,int orderNumber){
        double totalAmount = 0;
        for (Pizza pizza : pizzas) {
            System.out.println("Name: " + PizzaService.pizzasDefaultName(customer.getName(), orderNumber, pizza.getName()));
            System.out.println("--------------------------------");
            System.out.println("Pizza Base (" + pizza.getType() + ") " + pizza.getPizzaBaseCost() + " €");
            IngredientService.printPizzasIngredients(pizza.getIngredients());
            System.out.println("--------------------------------");
            System.out.println("Amount: " + (IngredientService.calculatePizzasIngredientsCost(pizza.getIngredients()) + pizza.getPizzaBaseCost()) + " €");
            System.out.println("Quantity: " + pizza.getQuantity());
            System.out.println("--------------------------------");
            totalAmount += IngredientService.calculatePizzasIngredientsCost(pizza.getIngredients()) + pizza.getPizzaBaseCost();
        }
        System.out.println("Total amount: " + totalAmount + " €");
    }
}
