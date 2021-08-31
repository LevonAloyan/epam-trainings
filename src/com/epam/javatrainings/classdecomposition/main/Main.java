package com.epam.javatrainings.classdecomposition.main;

import com.epam.javatrainings.classdecomposition.model.Customer;
import com.epam.javatrainings.classdecomposition.model.Ingredient;
import com.epam.javatrainings.classdecomposition.model.Pizza;
import com.epam.javatrainings.classdecomposition.model.PizzaType;
import com.epam.javatrainings.classdecomposition.util.PizzaUtil;
import com.epam.javatrainings.classdecomposition.validator.Validator;

import java.util.Scanner;

/**
 * Created by Hayk on 31.08.2021.
 */
public class Main {
    private static Scanner input_scanner = new Scanner(System.in);

    private static String input(String message) {
        System.out.println(message);
        return input_scanner.nextLine();
    }

    public static void printIngredients() {
        for (Ingredient ingredient : Ingredient.values()) {
            System.out.println(ingredient.ordinal() + 1 + "--->" + ingredient.name());
        }
    }

    public static void main(String[] args) {

        String command = "";
        do {
            System.out.println("-----------------------Enter 'exit' for exit------------------------------------");
            String name = input("Please enter your name");
            Customer customer = new Customer(name);
            System.out.println("Select the numbers of ingredient");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printIngredients();
            String ingredientCommand;
            int index = 0;
            Ingredient[] ingredients = new Ingredient[8];
            do {

                ingredientCommand = input("Enter numbers 1-8 or other to finish");
                if (Validator.isInt(ingredientCommand)) {
                    int number = Integer.parseInt(ingredientCommand);
                    if (number > 0 && number < 9) {
                        ingredients[index++] = Ingredient.values()[number - 1];
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            } while (index < 8);
            Pizza pizza = new Pizza();
            String type = input("Input type of Pizza --->REGULAR(by defalt) or CALZONE");
            if (type.toLowerCase().equals("CALZONE")) {
                pizza.setType(PizzaType.CALZONE);
            } else {
                pizza.setType(PizzaType.REGULAR);
            }
            name = input("Please enter the name of Pizza");
            pizza.setName(PizzaUtil.generateName(name, customer, pizza.getOrderNumber()));
            pizza.setIngredients(ingredients);
            String countString = input("How much pizza you want?(1 by defalt)");
            int count = 1;
            if (Validator.isInt(countString)) {
                count = Integer.parseInt(countString);
            }
            pizza.setQuantity(count);

            System.out.println("Please wait...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Your order is ready");
            pizza.printContent(customer.getId());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!command.toLowerCase().equals("exit"));
    }
}
