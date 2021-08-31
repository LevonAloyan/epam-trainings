package com.epam.javatrainings.classdecomposition;

import java.util.Scanner;

public class Pizza {

    private double price;

    public static void pizzaName() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter pizza name: ");
        String pizzaname = scanner.nextLine();

        for (PizzaName name : PizzaName.values()) {
            if (name.name().equals(pizzaname)) {
                System.out.println("You select: " + pizzaname);
                break;
            } else {
                System.out.println("Special for you: " + Customer.getCustomerName());
                break;
            }
        }
    }

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
}
