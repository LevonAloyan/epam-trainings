package com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services;

import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.Ingredients;
import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.Pizza;
import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.PlacingAnOrder;

import static com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services.Constants.ASTERISK;
import static com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services.Constants.LINE;

public class OrderService implements OrderCreator, Validator {
  private final PlacingAnOrder order;

  public OrderService(PlacingAnOrder order) {
    this.order = order;
  }



  public void printCheck() {
    System.out.println(ASTERISK);
    System.out.println("Order: " + order.getOrderNumber());
    System.out.println("Client: " + order.getCustomer().getNumberCustomer());
    System.out.println("Time: " + order.getLocalTime());
    for (Pizza pizza : order.getOrderItems()) {
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
    System.out.println("Total amount: " + order.costOrder() + " €");
    System.out.println(ASTERISK);
  }

  @Override
  public Pizza create(String name, String type, int quantity) {
    Pizza pizza = new Pizza(validateName(name), type, quantity);
    order.getOrderItems().add(pizza);
    return pizza;
  }

  @Override
  public String validateName(String namePizza) {
    if (((namePizza != null)
        && (namePizza.matches("^[a-zA-Z]*$"))
        && (namePizza.length() >= Constants.MIN_LENGTH_NAME_PIZZA)
        && namePizza.length() <= Constants.MAX_LENGTH_NAME_PIZZA)) {
      return namePizza;
    } else {
      return order.getCustomer().getNameCustomer() + "_" + order.getOrderNumber();
    }
  }
}
