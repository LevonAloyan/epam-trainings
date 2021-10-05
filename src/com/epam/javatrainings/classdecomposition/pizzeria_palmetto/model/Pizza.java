package com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model;

import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services.Constants;

import static com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services.Constants.*;
import java.util.ArrayList;
import java.util.List;

public class Pizza {
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
    if (quantity > QUANTITY_PIZZA_MIN && quantity <= QUANTITY_PIZZA_MAX) {
      this.quantity = quantity;
    } else if (quantity > QUANTITY_PIZZA_MAX) {
      this.quantity = QUANTITY_PIZZA_MAX;
    } else if (quantity <= QUANTITY_PIZZA_MIN) {
      this.quantity = QUANTITY_PIZZA_DEFAULT;
    }
  }

  public double getCostPizza() {
    double costPizza = INITIAL_COST;
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
}
