package com.epam.javatrainings.classdecomposition.model.service;

import com.epam.javatrainings.classdecomposition.model.Customer;
import com.epam.javatrainings.classdecomposition.model.Ingredient;
import com.epam.javatrainings.classdecomposition.model.Order;
import com.epam.javatrainings.classdecomposition.model.Pizza;
import com.epam.javatrainings.classdecomposition.model.enums.PizzaType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PizzaService {


    public static List<Pizza> createPizza() {
        Order order = new Order();
        List<Pizza> pizzas = new ArrayList<>();
        String name = null;
        PizzaType pizzaType = null;
        for (int i = 0; i < 10; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter  and add other pizza or finish");
            String enter =  scanner.nextLine();
            if(enter.equals("finish")){
                break;
            }

            name = setName(order);
            System.out.println("Enter type of pizza");
            String type = scanner.nextLine();

            if (type.equals(PizzaType.REGULAR.toString())) {
                pizzaType = PizzaType.REGULAR;
            } else {
                pizzaType = PizzaType.CLOSED;
            }
            System.out.println("Enter quantity :");
            int quantity = scanner.nextInt();

            pizzas.add(new Pizza(name, pizzaType, quantity, setIngredientList()));
        }

        return pizzas;
    }


    public static Pizza addIngredient(Pizza pizza, Ingredient newIngredient) {
        if (pizza.getIngredientList().size() >= 7) {
            System.out.println("Pizza is full :( , please check your Order ");
            return pizza;
        } else if (pizza.getIngredientList().contains(newIngredient)) {
            System.out.println("There are duplicate ingredients , please check your order");
            return pizza;
        } else {
            pizza.getIngredientList().add(newIngredient);
            return pizza;
        }
    }

    public static String setName( Order order) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pizza Name : ");

        String name = scanner.nextLine();


        if (!(name.length() >= 4 && name.length() <= 20)) {
            System.out.println("it;s Okay :) ");
            return order.getCustomer().getName() + "_" + order.getNumberOfOrder();
        }

        return name;


    }


    public static List<Ingredient> setIngredientList() {
        List<Ingredient> ingredientList = new ArrayList<>();


        for (int i = 0; i < 7; i++) {
            Ingredient ingredient = new Ingredient();
            System.out.println("Enter Next Ingredient  or finish : ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            if (name.equals("finish")) {
                break;
            }
            ingredient.setName(name);
            System.out.println("Enter " + name + " price");

            ingredient.setPrice(scanner.nextDouble());
            ingredientList.add(ingredient);
        }
        return ingredientList;
    }

}
