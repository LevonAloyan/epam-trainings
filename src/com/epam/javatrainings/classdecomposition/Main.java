package com.epam.javatrainings.classdecomposition;

import com.epam.javatrainings.classdecomposition.order.Order;
import com.epam.javatrainings.classdecomposition.pizza.Pizza;
import com.epam.javatrainings.classdecomposition.pizza.PizzaType;
import com.epam.javatrainings.classdecomposition.customer.Customer;
import com.epam.javatrainings.classdecomposition.order.OrderPrinter;
import com.epam.javatrainings.classdecomposition.order.orderitem.OrderItem;
import com.epam.javatrainings.classdecomposition.order.orderitem.QuantityUnit;
import com.epam.javatrainings.classdecomposition.ingredient.AvailableIngredientList;

import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Part 1
        Pizza margherita = new Pizza("Margherita", PizzaType.CALZONE);
        System.out.println("Part 1\nMargherita without ingredients:\n\t" + margherita + "\n");

        AvailableIngredientList availableIngredients = AvailableIngredientList.getInstance();
        Pizza califomia = new Pizza(
                "Califomia",
                PizzaType.CALZONE,
                new ArrayList<>(
                        Arrays.asList(
                                availableIngredients.findIngredientByName("tomato paste"),
                                availableIngredients.findIngredientByName("olives"),
                                availableIngredients.findIngredientByName("cheese")
                        )));
        System.out.println("Califomia with 3 ingredients:\n\t" + califomia + "\n");
        OrderItem oi1 = new OrderItem.OrderItemBuilder(margherita, 3, QuantityUnit.WHOLE).build();
        OrderItem oi2 = new OrderItem.OrderItemBuilder(califomia, 7, QuantityUnit.WHOLE).build();
        Customer bob = new Customer("bob");
        Order o1 = new Order.OrderBuilder(bob, oi1).build();
        OrderPrinter.printOrderDescription(o1);

        Order o2 = new Order.OrderBuilder(
                new Customer("Jack"),
                new ArrayList<>(Arrays.asList(oi1, oi2)
                )).build();
        OrderPrinter.printOrderDescription(o2);
        // Part 2
        margherita.addIngredient(availableIngredients.findIngredientByName("tomato paste"));
        margherita.addIngredient(availableIngredients.findIngredientByName("pepper"));
        margherita.addIngredient(availableIngredients.findIngredientByName("garlic"));
        margherita.addIngredient(availableIngredients.findIngredientByName("bacon"));
        System.out.println("Part 2\nMargherita filled with [tomato paste, pepper, garlic, and bacon] " +
                "(pepper is not available! ):\n\t" + margherita + "\n");
        Pizza anotherPizza = new Pizza("AnotherPizza", PizzaType.REGULAR);
        anotherPizza.addIngredient(availableIngredients.findIngredientByName("tomato paste"));
        anotherPizza.addIngredient(availableIngredients.findIngredientByName("cheese"));
        anotherPizza.addIngredient(availableIngredients.findIngredientByName("salami"));
        anotherPizza.addIngredient(availableIngredients.findIngredientByName("olives"));
        System.out.println("AnotherPizza filled with available ingredients:\n\t" + anotherPizza);
        // Part 3
        System.out.println("Part 3");
        OrderItem oi_3 = new OrderItem.OrderItemBuilder(margherita, 3, QuantityUnit.WHOLE).build();
        Order o_3 = new Order.OrderBuilder(
                new Customer("Jack"),
                new ArrayList<>(Arrays.asList(oi_3, oi2)
                )).build();
        OrderPrinter.printCheck(o_3);
        // Part 4
        System.out.println("Part 4_1");
        Customer customer4 = new Customer("Part4Customer");
        OrderItem oi4_1 = new OrderItem.OrderItemBuilder(
                margherita, 2, QuantityUnit.SLICE
        ).build();
        Pizza pepperoniOro = new Pizza(
                "PepperoniOro",
                PizzaType.REGULAR,
                new ArrayList<>(
                        Arrays.asList(
                                availableIngredients.findIngredientByName("tomato paste"),
                                availableIngredients.findIngredientByName("olives"),
                                availableIngredients.findIngredientByName("cheese")

                        )));
        OrderItem oi4_2 = new OrderItem.
                OrderItemBuilder(pepperoniOro, 3, QuantityUnit.SLICE).build();
        Order order_4 = new Order.OrderBuilder(customer4, new ArrayList<>(Arrays.asList(oi4_1, oi4_2))).build();
        OrderPrinter.printOrderDescription(order_4);
        OrderPrinter.printCheck(order_4);
        // Part 4_2
        System.out.println("Part 4_2");
        Customer customer_7717 = new Customer("Someone");
        Pizza basePZZ = new Pizza("BasePZZ", PizzaType.REGULAR,
                new ArrayList<>(
                        Arrays.asList(
                                availableIngredients.findIngredientByName("pepperoni"),
                                availableIngredients.findIngredientByName("olives"),
                                availableIngredients.findIngredientByName("cheese"),
                                availableIngredients.findIngredientByName("corn")

                        )));
        OrderItem oi_7717 = new OrderItem.
                OrderItemBuilder(basePZZ, 12, QuantityUnit.SLICE).build();
        Order o_7717 = new Order.OrderBuilder(customer_7717, oi_7717, true).build();
        OrderPrinter.printOrderDescription(o_7717);
        OrderPrinter.printCheck(o_7717);
        System.out.println("Is this order for delivery: " + o_7717.isForDelivery());

    }
}
