package com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model;

import static com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services.Constants.*;
import java.util.EnumSet;
import java.util.Set;

public class Pizza {
  private final String name;
  private Type type;
  private int quantity;
  private final Set<Ingredients> ingredientsList;

  public Pizza(String name, Type type, int quantity) {
    this.setQuantity(quantity);
    this.name = name;
    this.setType(type);
    this.ingredientsList = EnumSet.noneOf(Ingredients.class);
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

  public Set<Ingredients> getIngredientsList() {
    return ingredientsList;
  }

  public void setQuantity(int quantity) {
    if (quantity > QUANTITY_PIZZA_MIN && quantity <= QUANTITY_PIZZA_MAX) {
      this.quantity = quantity;
    } else if (quantity > QUANTITY_PIZZA_MAX) {
      this.quantity = QUANTITY_PIZZA_MAX;
    } else {
      this.quantity = QUANTITY_PIZZA_DEFAULT;
    }
  }

  public double costPizza() {
    return ingredientsList.stream()
        .map(Ingredients::getCost)
        .reduce(INITIAL_COST + type.getCost(), Double::sum);
  }

  public void setType(Type type) {
    this.type = type == Type.CALZONE ? Type.CALZONE : Type.REGULAR;
  }
}
