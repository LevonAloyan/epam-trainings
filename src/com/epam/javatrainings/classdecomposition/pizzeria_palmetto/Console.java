package com.epam.javatrainings.classdecomposition.pizzeria_palmetto;

import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.*;
import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services.PlacingAnOrderService;
import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services.PizzaService;
import static com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services.Constants.*;

public class Console {

  public static void main(String[] args) {

    // Created customer1 and customer2 where they give  name and id number
    Customer customer1 = new Customer(NAME_CUSTOMER_1, CUSTOMER_NUMBER_1);
    Customer customer2 = new Customer(NAME_CUSTOMER_2, CUSTOMER_NUMBER_2);

    // Customers can create an orders
    PlacingAnOrder placingAnOrder1 = new PlacingAnOrder(customer1);
    PlacingAnOrder placingAnOrder2 = new PlacingAnOrder(customer2);

    // Create services
    PlacingAnOrderService orderService = new PlacingAnOrderService();
    PizzaService pizzaService = new PizzaService();

    // The customer1 added pizza
    Pizza pizza = new Pizza(NAME_PIZZA_1, Type.CALZONE, QUANTITY_PIZZA_1);
    pizzaService.validateName(pizza, placingAnOrder1);
    orderService.addPizza(pizza, placingAnOrder1);

    // Add ingredient
    pizzaService.addIngredient(Ingredients.TOMATO_PASTE, pizza);
    pizzaService.addIngredient(Ingredients.GARLIC, pizza);
    pizzaService.addIngredient(Ingredients.BACON, pizza);
    pizzaService.addIngredient(Ingredients.PEPPERONI, pizza);

    // The customer1 adds another pizza
    pizza = new Pizza(NAME_PIZZA_2, Type.REGULAR, QUANTITY_PIZZA_2);
    pizzaService.validateName(pizza, placingAnOrder1);
    orderService.addPizza(pizza, placingAnOrder1);

    // Add ingredient
    pizzaService.addIngredient(Ingredients.TOMATO_PASTE, pizza);
    pizzaService.addIngredient(Ingredients.CHEESE, pizza);
    pizzaService.addIngredient(Ingredients.PEPPERONI, pizza);
    pizzaService.addIngredient(Ingredients.OLIVES, pizza);
    orderService.printCheck(placingAnOrder1);

    // The customer2 added pizza
    pizza = new Pizza(NAME_PIZZA_3, Type.REGULAR, QUANTITY_PIZZA_3);
    pizzaService.validateName(pizza, placingAnOrder2);
    pizzaService.validateName(pizza, placingAnOrder2);

    // Add ingredient
    pizzaService.addIngredient(Ingredients.TOMATO_PASTE, pizza);
    pizzaService.addIngredient(Ingredients.CHEESE, pizza);
    pizzaService.validateName(pizza, placingAnOrder2);
    orderService.addPizza(pizza, placingAnOrder2);

    // Print check
    orderService.printCheck(placingAnOrder2);

    //Print printAttributes
    pizzaService.printAttributes(placingAnOrder2,pizza);
  }
}
