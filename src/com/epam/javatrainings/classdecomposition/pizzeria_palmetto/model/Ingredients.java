package com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model;

public enum Ingredients {
  TOMATO_PASTE("Tomato paste", 1.0),
  CHEESE("Cheese", 1.0),
  SALAMI("Salami", 1.5),
  BACON("Bacon", 1.2),
  GARLIC("Garlic", 0.3),
  CORN("Corn", 0.7),
  PEPPERONI("Pepperoni", 0.6),
  OLIVES("Olives", 0.5);
  private final String key;
  private final Double cost;

  Ingredients(String key, Double cost) {
    this.key = key;
    this.cost = cost;
  }

  public String getKey() {
    return key;
  }

  public Double getCost() {
    return cost;
  }
}
