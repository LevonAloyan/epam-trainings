package com.epam.javatrainings.classdecomposition;

import com.epam.javatrainings.classdecomposition.customer.Customer;
import com.epam.javatrainings.classdecomposition.ingredient.PizzaIngredients;
import com.epam.javatrainings.classdecomposition.pizza.Pizza;
import com.epam.javatrainings.classdecomposition.pizza.PizzaType;
import com.epam.javatrainings.classdecomposition.order.Order;
import com.epam.javatrainings.classdecomposition.order.OrderItem;
import com.epam.javatrainings.classdecomposition.order.OrderPrinter;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Customer bob = new Customer("bob");

        //Create pizza Margherita with no ingredients
        Pizza margherita = new Pizza("Margherita", PizzaType.REGULAR);
        System.out.println("margherita: " + margherita);

        margherita.addIngredient(PizzaIngredients.findIngredientByName("tomato paste"));
        margherita.addIngredient(PizzaIngredients.findIngredientByName("pepper"));
        margherita.addIngredient(PizzaIngredients.findIngredientByName("garlic"));
        margherita.addIngredient(PizzaIngredients.findIngredientByName("bacon"));
        System.out.println("margherita filled with available ingredients: " + margherita);

        //Create pizza AnotherOne with no ingredients
        Pizza anotherPizza = new Pizza("AnotherOne", PizzaType.REGULAR);
        System.out.println("anotherPizza: " + anotherPizza);

        anotherPizza.addIngredient(PizzaIngredients.findIngredientByName("tomato paste"));
        anotherPizza.addIngredient(PizzaIngredients.findIngredientByName("cheese"));
        anotherPizza.addIngredient(PizzaIngredients.findIngredientByName("salami"));
        anotherPizza.addIngredient(PizzaIngredients.findIngredientByName("olives"));
        System.out.println("anotherPizza filled with available ingredients: " + margherita);


        OrderItem orderItem1 = new OrderItem.OrderItemBuilder(margherita, 3).build();
        OrderItem orderItem2 = new OrderItem.OrderItemBuilder(anotherPizza, 6).build();

        Order order = new Order.OrderBuilder(bob, new ArrayList<>(Arrays.asList(orderItem1, orderItem2))).build();

        OrderPrinter.printOrderDescription(order);

    }
}
