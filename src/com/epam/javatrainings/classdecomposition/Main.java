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
        System.out.println("bob's id is: " + bob.getCustomerId());

        //Create pizza with no ingredients
        Pizza p1 = new Pizza("Mar", PizzaType.REGULAR, new ArrayList<>());
        System.out.println("p1 = " + p1);
        Pizza p2 = new Pizza("p2", PizzaType.CALZONE);
        System.out.println("p2 = " + p2);

        //Create pizza with ingredients
        Pizza p3 = new Pizza("zzz", PizzaType.CALZONE,
                new ArrayList<>(
                        Arrays.asList(
                                PizzaIngredients.getPizzaIngredients().get(0),
                                PizzaIngredients.getPizzaIngredients().get(1),
                                PizzaIngredients.getPizzaIngredients().get(3),
                                PizzaIngredients.getPizzaIngredients().get(4)
                        )

                )
        );
        System.out.println("p3 = " + p3);

        Pizza p4 = new Pizza("piz", PizzaType.REGULAR,
                new ArrayList<>(
                        Arrays.asList(
                                PizzaIngredients.getPizzaIngredients().get(5),
                                PizzaIngredients.getPizzaIngredients().get(6),
                                PizzaIngredients.getPizzaIngredients().get(7)
                        )

                )
        );
        System.out.println("p4 = " + p4);

        OrderItem orderItem1 = new OrderItem.OrderItemBuilder(p3, 3).build();
        OrderItem orderItem2 = new OrderItem.OrderItemBuilder(p4, 7).build();

        Order order = new Order.OrderBuilder(bob, new ArrayList<>(Arrays.asList(orderItem1, orderItem2))).build();

        OrderPrinter.printOrderDescription(order);

    }
}
