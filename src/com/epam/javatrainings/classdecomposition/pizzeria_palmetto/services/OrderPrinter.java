package com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services;

import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.Ingredients;
import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.Pizza;
import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.PlacingAnOrder;

public class OrderPrinter {
  public static final String LINE = "--------------------------------";
  public static final String ASTERISK = "********************************";

  public static void printCheck(PlacingAnOrder placingAnOrder) {
    System.out.println(ASTERISK);
    System.out.println("Order: " + placingAnOrder.getOrderNumber());
    System.out.println("Client: " + placingAnOrder.getCustomer().getNumberCustomer());
    System.out.println("Time: " + placingAnOrder.getLocalTime());
    for (Pizza pizza : placingAnOrder.getOrderItems()) {
      System.out.println("Name: " + pizza.getName());
      System.out.println(LINE);
      System.out.println(
          "Pizza Base " + "(" + pizza.getType() + ")" + pizza.getType().getCost() + " €");

      for (String ingredient : Pizza.ingredientsList) {
        for (Ingredients ingredients : Ingredients.values()) {
          if (ingredients.getKey().equals(ingredient)) {
            System.out.println(ingredient + " " + ingredients.getCost());
          }
        }
      }
      System.out.println(LINE);
      System.out.println("Amount: " + pizza.getCostPizza() + " €");
      System.out.println("Quantity: " + pizza.getQuantity());
      System.out.println(LINE);
    }
    System.out.println("Total amount: " + placingAnOrder.costOrder() + " €");
    System.out.println(ASTERISK);
  }
}
