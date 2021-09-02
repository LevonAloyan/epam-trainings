package com.epam.javatrainings.classdecomposition;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public final class UserInterface {
    private Scanner scanner;

    private static UserInterface userInterface = null;

    private UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public static UserInterface userInterfaceFactory(Scanner scanner) {
        if (userInterface == null) {
            return new UserInterface(scanner);
        } else {
            return userInterface;
        }
    }

    //obtain customer name through scanner
    public String getCustomerName() {
        String customerName;
        try {
            System.out.println("Please enter your name");
            customerName = scanner.nextLine();
            customerName = customerName.length() <= 15 ? customerName : customerName.substring(0, 14);
            if (customerName.isEmpty()) {
                throw new Exception();
            }
            System.out.println("Customer name: " + customerName);
            return customerName;
        } catch (Exception ex) {
            scanner.nextLine();
            System.out.println("--------------------------------------");
            System.out.println("Please follow the instruction above!!");
            System.out.println("--------------------------------------");
            return getCustomerName();
        }
    }

    //obtain customer phone number through scanner
    public long getCustomerPhoneNumber() {
        long customerPhoneNumber;
        try {
            System.out.println("Please enter your phone number");
            customerPhoneNumber = scanner.nextLong();
            System.out.println("Customer phone number: " + customerPhoneNumber);
            return customerPhoneNumber;
        } catch (Exception exception) {
            scanner.nextLine();
            System.out.println("--------------------------------------");
            System.out.println("Please follow the instruction above!!");
            System.out.println("--------------------------------------");
            return getCustomerPhoneNumber();
        }
    }

    //obtain pizza name through scanner
    public String getPizzaName() {
        String pizzaName;
        try {
            System.out.println("Order a pizza with options below");
            System.out.println("Indicate the name of the pizza, it must be from four to twenty Latin letters, \n" +
                    "otherwise, the default name will be chosen");
            pizzaName = scanner.next();
            System.out.println("Pizza name: " + pizzaName);
            return pizzaName;
        } catch (Exception ex) {
            scanner.nextLine();
            System.out.println("--------------------------------------");
            System.out.println("Please follow the instruction above!!");
            System.out.println("--------------------------------------");
            return getPizzaName();
        }
    }

    //obtain pizza name through scanner
    public String getPizzaType() {
        String pizzaType;
        try {
            System.out.println("There are two types of pizza: regular 1.0$ and closed 1.5$ \n" +
                    "Please enter 1 if you want a closed-type pizza, otherwise, the pizza will be regular");
            int type = scanner.nextInt();
            pizzaType = type == 1 ? "closed" : "regular";
            System.out.println("Pizza type: " + pizzaType);
            return pizzaType;
        } catch (Exception ex) {
            scanner.nextLine();
            System.out.println("--------------------------------------");
            System.out.println("Please follow the instruction above!!");
            System.out.println("--------------------------------------");
            return getPizzaType();
        }
    }

    //obtain pizza ingredients through scanner
    public int getIngredients() {
        int pizzaIngredients;
        try {
            System.out.println("Please select the required ingredients by their serial number \n" +
                    "The maximum number of ingredients allowed is seven");
            int counter = 1;
            for (PizzeriaPalmetto.PizzaIngredients el : PizzeriaPalmetto.PizzaIngredients.values()) {
                System.out.println(counter++ + ": " + el + "-" + el.getCost() + "$");
            }
            pizzaIngredients = scanner.nextInt();
            return pizzaIngredients;
        } catch (Exception ex) {
            scanner.nextLine();
            System.out.println("--------------------------------------");
            System.out.println("Please follow the instruction above!!");
            System.out.println("--------------------------------------");
            return getIngredients();
        }
    }

    //obtain pizza quantity through scanner
    public int getPizzaQuantity() {
        int pizzaQuantity;

        try {
            System.out.println("Please select the order quantity for pizza, the maximum possible quantity is ten");
            pizzaQuantity = scanner.nextInt();

            if (pizzaQuantity > 10) {
                System.out.println("\n\nYour order should not exceed 10 pieces!!");
                throw new Exception();
            }
            return pizzaQuantity;
        } catch (Exception ex) {
            scanner.nextLine();
            System.out.println("--------------------------------------");
            System.out.println("Please follow the instruction above!!");
            System.out.println("--------------------------------------");
            return getPizzaQuantity();
        }
    }

    //check the order is completed or not
    public int makeChoice() {
        int choice;
        try {
            System.out.println("---------------------------------------------");
            System.out.println("If you have completed the order, enter 1 \n" +
                    "If you want to complement the order, enter 2 \n" +
                    "If you want to change the order, enter 3");
            System.out.println("1: complete");
            System.out.println("2: complement");
            System.out.println("3: change order");
            System.out.println("---------------------------------------------");
            choice = scanner.nextInt();
            return choice;
        } catch (Exception exception) {
            scanner.nextLine();
            System.out.println("--------------------------------------");
            System.out.println("Please follow the instruction above!!");
            System.out.println("--------------------------------------");
            return makeChoice();
        }
    }

    //show current order
    public int showCurrentOrder(Order order) {
        int choice = 0;
        List<PizzaBuilder.Pizza> pizzaList = order.getPizzaList();
        int count = 1;
        System.out.println("Choose pizza ordering number to add ingredients");
        for (PizzaBuilder.Pizza pizza : pizzaList) {
            System.out.println(count + ": " + pizza.getName() + " " + pizza.getIngredientList());
            count++;
        }
        choice = choosePizzaToAddIngredients(pizzaList);
        return choice;
    }

    //chose pizza to add new ingredients
    private int choosePizzaToAddIngredients(List<PizzaBuilder.Pizza> pizzaList) {
        int pizzaIndex = 0;
        try {
            pizzaIndex = scanner.nextInt();
            pizzaIndex -= 1;
            if (pizzaIndex >= 0 && pizzaIndex < pizzaList.size()) {
                return pizzaIndex;
            } else {
                System.out.println("The pizza from this number does not exist");
                return  -1;
            }
        } catch (Exception ex) {
            scanner.nextLine();
            System.out.println("--------------------------------------");
            System.out.println("Please follow the instruction above!!");
            System.out.println("--------------------------------------");
            choosePizzaToAddIngredients(pizzaList);
        }
        return pizzaIndex;
    }

    //if pizza is already full return to changeOrder() method
    //otherwise delegate adding process to addAvailableIngredients() method
    public int addIngredients(PizzaBuilder.Pizza pizza) {
        Set<String> ingredientList ;
        ingredientList = pizza.getIngredientList();
        int ingredients = 0;
        System.out.println(pizza.getName() + " " + ingredientList);
        if (ingredientList.size() >= 7) {
            System.out.println("the list of pizza ingredients is already full,\n" +
                    "you cannot add others");
        } else {
            showAvailableIngredients(ingredientList);
            ingredients = addAvailableIngredients();
        }
        return ingredients;
    }

    //chose available ingredients
    private int addAvailableIngredients() {
        int ingredients = 0;
        try {
            ingredients = scanner.nextInt();
            return ingredients;
        } catch (Exception ex) {
            scanner.nextLine();
            System.out.println("--------------------------------------");
            System.out.println("Please follow the instruction above!!");
            System.out.println("--------------------------------------");
            return addAvailableIngredients();
        }
    }

    //show available ingredients
    private void showAvailableIngredients(Set<String> ingredientList) {
        int counter = 1;
        System.out.println("Please select the required ingredients by their serial number");

        for (PizzeriaPalmetto.PizzaIngredients el : PizzeriaPalmetto.PizzaIngredients.values()) {
            if (!ingredientList.contains(el.name())) {
                System.out.println(counter + ": " + el + "-" + el.getCost() + "$");
            }
            counter++;
        }
    }
}
