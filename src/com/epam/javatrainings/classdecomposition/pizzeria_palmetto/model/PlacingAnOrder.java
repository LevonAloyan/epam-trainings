package com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model;

import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services.Constants;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PlacingAnOrder {
  public static int initialNumberOrder = Constants.INITIAL_NUMBER_ORDER;
  private final int orderNumber;
  private final Customer customer;
  private final List<Pizza> orderItems = new ArrayList<>();
  private final LocalTime localTime;

  public PlacingAnOrder(Customer customer) {
    this.orderNumber = initialNumberOrder++;
    this.customer = customer;
    this.localTime = LocalTime.now();
  }

  public int getOrderNumber() {
    return orderNumber;
  }

  public Customer getCustomer() {
    return customer;
  }

  public List<Pizza> getOrderItems() {
    return orderItems;
  }

  public LocalTime getLocalTime() {
    return localTime;
  }

  public double costOrder() {
    double orderCost = Constants.INITIAL_COST;
    for (Pizza pizza : orderItems) {
      orderCost += pizza.getCostPizza() * pizza.getQuantity();
    }
    return orderCost;
  }
}
