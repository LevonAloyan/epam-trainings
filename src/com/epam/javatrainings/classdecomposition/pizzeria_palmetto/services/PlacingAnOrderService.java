package com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services;

import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.Pizza;
import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.PlacingAnOrder;

import static com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services.Constants.ASTERISK;
import static com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services.Constants.LINE;

public class PlacingAnOrderService implements OrderCreator {

  public void printCheck(PlacingAnOrder order) {

    System.out.println(ASTERISK);
    System.out.println("Order: " + order.getOrderNumber());
    System.out.println("Client: " + order.getCustomer().getNumberCustomer());
    System.out.println("Time: " + order.getLocalTime());
    for (Pizza pizza : order.getOrderItems()) {
      System.out.println("Name: " + pizza.getName());
      System.out.println(LINE);
      System.out.println(
          "Pizza Base " + "(" + pizza.getType() + ")" + pizza.getType().getCost() + " €");

      pizza
          .getIngredientsList()
          .forEach(
              ingredients ->
                  System.out.println(ingredients.getKey() + " " + ingredients.getCost()+" €"));

      System.out.println(LINE);
      System.out.println("Amount: " + pizza.costPizza() + " €");
      System.out.println("Quantity: " + pizza.getQuantity());
      System.out.println(LINE);
    }
    System.out.println("Total amount: " + order.costOrder() + " €");
    System.out.println(ASTERISK);
  }

  @Override
  public Pizza addPizza(Pizza pizza, PlacingAnOrder order) {
    order.getOrderItems().add(pizza);
    return pizza;
  }
}
