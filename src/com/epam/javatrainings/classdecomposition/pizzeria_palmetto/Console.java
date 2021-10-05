package com.epam.javatrainings.classdecomposition.pizzeria_palmetto;

import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.Customer;
import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.Pizza;
import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.PlacingAnOrder;
import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services.OrderService;
import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services.PizzaService;
import static com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services.Constants.*;

public class Console {

  public static void main(String[] args) {

    // Created customer1 and customer2 where they give  name and id number
    Customer customer1 = new Customer(NAME_CUSTOMER_1, CUSTOMER_NUMBER_1);
    Customer customer2 = new Customer(NAME_CUSTOMER_2, CUSTOMER_NUMBER_2);
    // Customer can create an orders
    PlacingAnOrder placingAnOrder1 = new PlacingAnOrder(customer1);
    PlacingAnOrder placingAnOrder2 = new PlacingAnOrder(customer2);
    OrderService orderService1 = new OrderService(placingAnOrder1);
    OrderService orderService2 = new OrderService(placingAnOrder2);
    // Add  ingredient to pizza
    Pizza pizza = orderService1.create(NAME_PIZZA_1, TYPE_PIZZA_1, QUANTITY_PIZZA_1);
    PizzaService pizzaService = new PizzaService(pizza);
    pizzaService.addIngredient(INGREDIENT_1);
    pizzaService.addIngredient("Pepperoni");
    pizzaService.addIngredient("Garlic");
    pizzaService.addIngredient("Bacon");
    orderService1.create(NAME_PIZZA_2, TYPE_PIZZA_2, QUANTITY_PIZZA_2);
    pizzaService.addIngredient(INGREDIENT_1);
    pizzaService.addIngredient("Cheese");
    pizzaService.addIngredient("Pepperoni");
    pizzaService.addIngredient("Olives");
    // Print order1
    orderService1.printCheck();
    Pizza pizza1 = orderService2.create(NAME_PIZZA_3, TYPE_PIZZA_2, QUANTITY_PIZZA_3);
    PizzaService pizzaService1 = new PizzaService(pizza1);
    pizzaService1.addIngredient(INGREDIENT_1);
    pizzaService1.addIngredient("Cheese");
    // Print order2
    orderService2.printCheck();
    // Print Attributes
    pizzaService.printAttributes(placingAnOrder1);
  }
}
