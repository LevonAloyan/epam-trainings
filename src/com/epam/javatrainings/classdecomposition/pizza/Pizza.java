package com.epam.javatrainings.classdecomposition.pizza;

import com.epam.javatrainings.classdecomposition.customer.Customer;

import java.util.Scanner;

public class Pizza {

    public enum PizzaName {
        MARGARITA,
        PEPPERONI,
        ROMANA,
        CRUDO,
        NAPOLI
    }

    public enum PizzaType {
        REGULAR,
        CALZONE
    }

    private static String pizzaname;

    public static void pizzaName() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter pizza name: ");
        pizzaname = scanner.nextLine();
        if (pizzaname.length() > 3 && pizzaname.length() < 21) {
            for (PizzaName name : PizzaName.values()) {
                if (name.name().equals(pizzaname)) {
                    System.out.println("You select pizza: " + pizzaname);
                    break;
                } else {
                    System.out.println("Special for you: " + Customer.getCustomerName());
                    break;
                }
            }
        } else {
            System.out.println("Wrong pizza name : order number"/* + Order.getOrderNumber()*/);
        }
    }

    public static String getPizzaname() {
        return pizzaname;
    }
}
