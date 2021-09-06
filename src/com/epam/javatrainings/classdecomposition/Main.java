package com.epam.javatrainings.classdecomposition;

import com.epam.javatrainings.classdecomposition.order.Order;
import com.epam.javatrainings.classdecomposition.pizza.Pizza;
import com.epam.javatrainings.classdecomposition.pizza.PizzaType;
import com.epam.javatrainings.classdecomposition.customer.Customer;
import com.epam.javatrainings.classdecomposition.order.OrderPrinter;
import com.epam.javatrainings.classdecomposition.order.orderitem.OrderItem;
import com.epam.javatrainings.classdecomposition.ingredient.AvailableIngredientList;

import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Customer bob = new Customer("bob");
        // Create pizza Margherita with no ingredients
        Pizza margherita = new Pizza("Margherita", PizzaType.CALZONE);
        System.out.println("margherita without ingredients:\n\t" + margherita + "\n");

        AvailableIngredientList availableIngredients = AvailableIngredientList.getInstance();
        margherita.addIngredient(availableIngredients.findIngredientByName("tomato paste"));
        margherita.addIngredient(availableIngredients.findIngredientByName("pepper"));
        margherita.addIngredient(availableIngredients.findIngredientByName("garlic"));
        margherita.addIngredient(availableIngredients.findIngredientByName("bacon"));
        System.out.println("margherita filled with available ingredients:\n\t" + margherita + "\n");

        // Create pizza AnotherOne with no ingredients
        Pizza anotherPizza = new Pizza("AnotherOne", PizzaType.REGULAR);
        System.out.println("anotherPizza: " + anotherPizza);

        anotherPizza.addIngredient(availableIngredients.findIngredientByName("tomato paste"));
        anotherPizza.addIngredient(availableIngredients.findIngredientByName("cheese"));
        anotherPizza.addIngredient(availableIngredients.findIngredientByName("salami"));
        anotherPizza.addIngredient(availableIngredients.findIngredientByName("olives"));
        System.out.println("anotherPizza filled with available ingredients:\n\t" + margherita);

        OrderItem oi1 = new OrderItem.OrderItemBuilder(margherita, 3).build();
        Order order = new Order.OrderBuilder(bob, oi1).build();
        OrderPrinter.printOrderDescription(order);

        OrderItem oi2 = new OrderItem.OrderItemBuilder(anotherPizza, 7).build();
        Order order2 = new Order.OrderBuilder(new Customer("Jack"), new ArrayList<>(Arrays.asList(oi1, oi2))).build();
        OrderPrinter.printOrderDescription(order2);

        OrderPrinter.printCheck(order2);
    }
}
