package com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services;

import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.Ingredients;
import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.Pizza;
import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.PlacingAnOrder;

public class PizzaService implements IngredientsCreator, Validator {

  public void printAttributes(PlacingAnOrder order, Pizza pizza) {
    System.out.println(
        "["
            + order.getOrderNumber()
            + ":"
            + order.getCustomer().getNumberCustomer()
            + ":"
            + pizza.getName()
            + ":"
            + pizza.getQuantity()
            + "]");
  }

  @Override
  public boolean addIngredient(Ingredients ingredient, Pizza pizza) {
    if (pizza.getIngredientsList().size() == Ingredients.values().length) {
      System.out.println("The pizza is already full");
      return false;
    }
    if (pizza.getIngredientsList().contains(ingredient)) {
      System.out.println("Duplicate Ingredient, please check the order again");
      return false;
    }
    return pizza.getIngredientsList().add(ingredient);
  }

  @Override
  public String validateName(Pizza pizza, PlacingAnOrder order) {
    if (((pizza.getName() != null)
        && (pizza.getName().matches("^[a-zA-Z]*$"))
        && (pizza.getName().length() >= Constants.MIN_LENGTH_NAME_PIZZA)
        && pizza.getName().length() <= Constants.MAX_LENGTH_NAME_PIZZA)) {
      return pizza.getName();
    } else {
      return order.getCustomer().getNameCustomer() + "_" + order.getOrderNumber();
    }
  }
}
