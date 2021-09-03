package com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model;

import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services.IngredientsCreator;
import java.util.ArrayList;
import java.util.List;

public class Pizza implements IngredientsCreator {
  private String name;
  private Type type;
  private int quantity;
  public static List<String> ingredientsList;

  public Pizza(String name, String type, int quantity) {
    this.setQuantity(quantity);
    this.name = name;
    this.setType(type);
    ingredientsList = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public Type getType() {
    return type;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    if (quantity > 0 && quantity <= 10) {
      this.quantity = quantity;
    } else if (quantity > 10) {
      this.quantity = 10;
    } else if (quantity < 0) {
      this.quantity = 1;
    }
  }

  public double getCostPizza() {
    double costPizza = 0;
    for (Ingredients ingredients : Ingredients.values()) {
      for (String name : ingredientsList)
        if (name.equals(ingredients.getKey())) {
          costPizza += ingredients.getCost();
        }
    }
    return costPizza + type.getCost();
  }

  public void setType(String type) {
    if (type.equals(Type.CALZONE.getKey())) {
      this.type = Type.CALZONE;
    } else {
      this.type = Type.REGULAR;
    }
  }

  @Override
  public boolean addIngredient(String ingredient) {
    if (ingredientsList.size() == Ingredients.values().length) {
      System.out.println("The pizza is already full");
      return false;
    }
    if (ingredientsList.contains(ingredient)) {
      System.out.println("Duplicate Ingredient, please check the order again");
      return false;
    }
    for (Ingredients ingredients : Ingredients.values()) {
      if (ingredients.getKey().equals(ingredient)) {
        ingredientsList.add(ingredient);
      }
    }
    return true;
  }
}
