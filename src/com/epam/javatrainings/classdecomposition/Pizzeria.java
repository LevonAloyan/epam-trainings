package com.epam.javatrainings.classdecomposition;

import java.util.ArrayList;
import java.util.Scanner;

public class Pizzeria {

    public static void startApp() {
        System.out.println();
        System.out.println("Welcome to Pizzeria Palmetto!");
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            startPizzeria();
            input = scanner.next();
        } while(!input.equals("f"));
    }

    private static void startPizzeria() {
        Pizza.showAllAvailableIngredients();        //shows ingredients' list

        System.out.println("______________________________________________________________");
        System.out.println("Please, select the ingredients you prefer from the list above");
        System.out.println("Press f to to finish selecting the ingredients");
        System.out.print("Ingredients chosen: ");

        String selection = selectIngredients();
        ArrayList<Ingredient> selectedIngredients = toIngredients(selection);

        System.out.println("Your ordered ingredients: ");
        printIngredients(selectedIngredients);

        Pizza newPizza = makePizza();
        newPizza.setIngredients(selectedIngredients);
        makeOrder(newPizza);

        System.out.println();
        System.out.println("Press f to finish ordering, and n to make a new order");
    }

    private static String selectIngredients() {
        Scanner input = new Scanner(System.in);
        String choice = input.next();
        String ordered = "";
        while(!choice.equals("f")) {
            if(isValid(choice)) {
                ordered += choice;
            } else {
                System.out.println("Please, input a valid number");
            }
            choice = input.next();
        }
        return ordered;
    }

    private static boolean isValid(String input) {
        boolean isValid = false;
        for(int i = 0; i < input.length(); i++) {
            char n = input.charAt(i);
            if(Character.isDigit(n)) {
                isValid = true;
            } else {
                isValid = false;
            }
        }
        return isValid;
    }

    private static ArrayList<Ingredient> toIngredients(String input) {
        ArrayList<Ingredient> toReturnList = new ArrayList<>();
        ArrayList<Ingredient> availableIngrList = Pizza.allAvailableIngredients;

        for(int i = 0; i < input.length(); i++) {
            String c = "" + input.charAt(i);                      //gets each number of the selected ingredients
            int indexOfIngredient = Integer.parseInt(c);                 //parses into integer
            toReturnList.add(availableIngrList.get(indexOfIngredient));        //adds the ingredient to the list
        }

        return toReturnList;
    }

    private static Pizza makePizza() {
        Scanner input = new Scanner(System.in);
        System.out.print("Specify the name of the Pizza: ");
        String pizzaName = input.next();

        System.out.print("Specify the quantity of the Pizza: ");
        int pizzaQuantity = input.nextInt();
        while(pizzaQuantity > 10 || pizzaQuantity < 1) {
            System.out.println("You cannot order more than 10 pizzas");
            System.out.print("Specify the quantity of the Pizza again: ");
            pizzaQuantity = input.nextInt();
        }

        System.out.print("Specify the type of the Pizza (1 for Regular / 2 for Calzone): ");
        int pizzaType = input.nextInt();

        Pizza.Type type;
        while(pizzaType != 1 && pizzaType != 2) {
            System.out.print("Please, input only 1 or 2 for the Pizza type ");
            pizzaType = input.nextInt();
        }
        if(pizzaType == 1) {
            type =  Pizza.Type.REGULAR;
        } else {
            type =  Pizza.Type.CALZONE;
        }

        return new Pizza(pizzaName, pizzaQuantity, type);
    }

    private static void makeOrder(Pizza pizza) {
        Order order = new Order();
        order.placeOrder(pizza);
        if(pizza.getName().length() < 4 || pizza.getName().length() > 20) {
            pizza.setName("customer_name_" + pizza.getOrder().getOrderNumber());
        }
        System.out.println();
        System.out.println("            ORDER");
        order.checkout();
        order.printTotalPrice();
    }

    private static void printIngredients(ArrayList<Ingredient> list) {
        for (Ingredient ing:list) {
            System.out.println(" - " + ing.getName());
        }
    }
}
