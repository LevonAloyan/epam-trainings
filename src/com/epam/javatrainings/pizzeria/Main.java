package com.epam.javatrainings.pizzeria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Ingredient [] ingredients = new Ingredient[8];
        ingredients[0] = new Ingredient("Tomato paste",1);
        ingredients[1] = new Ingredient("Cheese",1);
        ingredients[2] = new Ingredient("Salami",1.5);
        ingredients[3] = new Ingredient("Bacon",1.2);
        ingredients[4] = new Ingredient("Garlic",0.3);
        ingredients[5] = new Ingredient("Corn",0.7);
        ingredients[6] = new Ingredient("Pepperoni",0.6);
        ingredients[7] = new Ingredient("Olives",0.5);

        Scanner myObj = new Scanner(System.in);

        System.out.println("Welcome to the pizzeria Palmetto!");
        System.out.println("Please enter your name:");
        String clientName = myObj.nextLine();
        Customer customer = new Customer(clientName);
        Order order = new Order(customer.id);
        int temp1 = 100000;
        Pizza pizza;
            while (temp1 != 0){
                System.out.println("Please enter name for pizza:");
            String pizzaName = myObj.nextLine();
             pizza = new Pizza(pizzaName, customer, order.getOrderNumber());

            System.out.println("Please choose ingredients: Enter appropriate number. Enter 0 to finish:");
            System.out.println("1   Tomato paste  ");
            System.out.println("2   Cheese  ");
            System.out.println("3   Salami  ");
            System.out.println("4   Bacon  ");
            System.out.println("5   Garlic  ");
            System.out.println("6   Corn  ");
            System.out.println("7   Pepperoni  ");
            System.out.println("8   Olives  ");

            //there is simple testing logic without catching exceptions

            int temp;
            do {
                temp = myObj.nextInt();
                if (temp > 0 && temp < 8) {
                    pizza.addIngredient(ingredients[temp - 1]);
                }
            }

            while (temp != 0);
                System.out.println("Please choose type: 1-Regular    2-Calzone");
                temp = myObj.nextInt();
                switch (temp){
                    case 1: pizza.setType(Type.Regular);
                    break;
                    case 2:pizza.setType(Type.Calzone);
                    break;
                    default:System.out.println("Wrong number");
                    break;
                }
                System.out.println("Please enter quantity:");
            temp = myObj.nextInt();
            pizza.setQuantity(temp);
            order.addPizza(pizza);
            System.out.println("Please enter 0 to finish the order. Press any other key to continue:");
            temp1 = myObj.nextInt();
            }
        System.out.println("Thank you for your order. It costs " + order.orderPrice() + '$');


    }
}
