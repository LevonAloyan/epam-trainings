package com.epam.javatrainings.classdecomposition;

import java.util.Scanner;

public class Service {
    private static int customerSerialNumber = 1;
    private static int orderSerialNumber = 10000;

    public Order makeOrder() {
        Order order = new Order(orderSerialNumber, customerSerialNumber);
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("order new pizza ?");
            if (order.getQuantity() < 10 && scanner.next().equals("yes")) {
                orderPizza(order, scanner);
            } else break;
        }
        increment();
        return order;
    }

    private void orderPizza(Order order, Scanner scanner) {
//        System.out.println("order new pizza?");
//        System.out.println("enter -yes- or -no-");
//        if (scanner.next().equals("yes")) {
            Pizza pizza = new Pizza();

            chooseType(scanner, pizza);
            chooseIngredients(scanner, pizza);
            setName(scanner, pizza);

            System.out.println("enter count");
            int count = scanner.nextInt();
            order.setPizzas(pizza, count);
//        }
    }

    private void setName(Scanner scanner, Pizza pizza) {
        System.out.println("enter pizza name");
        String name = scanner.next();
        pizza.setName(validateName(name));
    }

    private void chooseIngredients(Scanner scanner, Pizza pizza) {
        System.out.println("choose ingredients");
        System.out.println("enter -yes- or -no-");
        System.out.println("Tomato paste 1 $");
        if(scanner.next().equals("yes")) {
            pizza.setIngredients(PizzaIngredient.Tomato_paste);
        }
        System.out.println("Cheese	     1 $");
        if(scanner.next().equals("yes")) {
            pizza.setIngredients(PizzaIngredient.Cheese);
        }
        System.out.println("Salami	     1.5 $");
        if(scanner.next().equals("yes")) {
            pizza.setIngredients(PizzaIngredient.Salami);
        }
        System.out.println("Bacon	     1.2 $");
        if(scanner.next().equals("yes")) {
            pizza.setIngredients(PizzaIngredient.Bacon);
        }
        System.out.println("Garlic	     0.3 $");
        if(scanner.next().equals("yes")) {
            pizza.setIngredients(PizzaIngredient.Garlic);
        }
        System.out.println("Corn	     0.7 $");
        if(scanner.next().equals("yes")) {
            pizza.setIngredients(PizzaIngredient.Corn);
        }
        System.out.println("Pepperoni	 0.6 $");
        if(scanner.next().equals("yes")) {
            pizza.setIngredients(PizzaIngredient.Pepperoni);
        }
        System.out.println("Olives	     0.5 $");
        if(scanner.next().equals("yes")) {
            pizza.setIngredients(PizzaIngredient.Olives);
        }
    }

    private void chooseType(Scanner scanner, Pizza pizza) {
        System.out.println("choose pizza type");
        System.out.println("enter -regular- or -closed-");
        String s = scanner.next();
        if(s.equals("regular")) {
            pizza.setType(PizzaType.REGULAR);
        } else if(s.equals("closed")) {
            pizza.setType(PizzaType.CLOSED);
        }
    }

    private static void increment() {
        orderSerialNumber++;
        customerSerialNumber++;
    }

    private String validateName(String input) {
        if(input.length() >= 4 && input.length() <= 20) {
            return input;
        }
        return (String.format("custom_name_%s", orderSerialNumber));
    }
}
