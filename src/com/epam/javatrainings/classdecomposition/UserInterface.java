package com.epam.javatrainings.classdecomposition;

import java.util.Scanner;

public final class UserInterface {
    private Scanner scanner;

    private static UserInterface userInterface = null;

    private UserInterface(Scanner scanner){
        this.scanner = scanner;
    }

    public static UserInterface userInterfaceFactory(Scanner scanner){
        if (userInterface == null){
            return new UserInterface(scanner);
        }else {
            return userInterface;
        }
    }

    public String getCustomerName() {
        String customerName;
        try {
            System.out.println("Please enter your name");
            customerName = scanner.nextLine();
            customerName = customerName.length() <= 15 ? customerName : customerName.substring(0, 14);
            if(customerName.isEmpty()){
                throw new Exception();
            }
            System.out.println("Customer name: " + customerName);
            return customerName;
        }catch (Exception ex){
            scanner.nextLine();
            System.out.println("Please follow the instruction above!!");
            return getCustomerName();
        }
    }

    public long getCustomerPhoneNumber() {
        long customerPhoneNumber;
        try {
            System.out.println("Please enter your phone number");
            customerPhoneNumber = scanner.nextLong();
            System.out.println("Customer phone number: " + customerPhoneNumber);
            return customerPhoneNumber;
        }catch (Exception exception){
            scanner.nextLine();
            System.out.println("Please follow the instruction above!!");
            return getCustomerPhoneNumber();
        }
    }

    public String getPizzaName(){
        String pizzaName;
        try {
            System.out.println("Order a pizza with options below");
            System.out.println("Indicate the name of the pizza, it must be from four to twenty Latin letters, \n" +
                    "otherwise, the default name will be chosen");
            pizzaName = scanner.next();
            System.out.println("Pizza name: " + pizzaName);
            return pizzaName;
        }catch (Exception ex){
            scanner.nextLine();
            System.out.println("Please follow the instruction above!!");
            return getPizzaName();
        }
    }

    public String getPizzaType(){
        String pizzaType;
        try {
            System.out.println("There are two types of pizza: regular 1.0$ and closed 1.5$ \n" +
                    "Please enter 1 if you want a closed-type pizza, otherwise, the pizza will be regular");
            int type = scanner.nextInt();
            pizzaType = type == 1 ? "closed" : "regular";
            System.out.println("Pizza type: " + pizzaType);
            return pizzaType;
        }catch (Exception ex){
            scanner.nextLine();
            System.out.println("Please follow the instruction above!!");
            return getPizzaType();
        }
    }

    public int getIngredients(){
        int pizzaIngredients;
        try{
            System.out.println("Please select the required ingredients by their serial number \n" +
                    "The maximum number of ingredients allowed is seven");
            int counter = 1;
            for (PizzeriaPalmetto.PizzaIngredients el : PizzeriaPalmetto.PizzaIngredients.values()) {
                System.out.println(counter++ + ": " + el + "-" + el.getCost() + "$");
            }
            pizzaIngredients = scanner.nextInt();
            return pizzaIngredients;
        }catch (Exception ex){
            scanner.nextLine();
            System.out.println("Please follow the instruction above!!");
            return getIngredients();
        }
    }

    public int getPizzaQuantity(){
        int pizzaQuantity;

        try {
            System.out.println("Please select the order quantity for pizza, the maximum possible quantity is ten");
            pizzaQuantity = scanner.nextInt();

            if (pizzaQuantity > 10) {
                System.out.println("\n\nYour order should not exceed 10 pieces!!");
                throw new Exception();
            }
            return pizzaQuantity;
        }catch (Exception ex){
            scanner.nextLine();
            System.out.println("Please follow the instruction above!!");
            return getPizzaQuantity();
        }finally {
           scanner.nextLine();
        }
    }
}
