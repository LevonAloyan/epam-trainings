package com.epam.javatrainings.classdecomposition;

import java.util.*;


public class PizzeriaPalmetto {

    private enum PizzaIngredients {
        TOMATO_PASTE(1.0), CHEESE(1.0), SALAMI(1.5),
        BACON(1.2), GARLIC(0.3), CORN(0.7), PEPPERONI(0.6), OLIVES(0.5);

        private double cost;

        PizzaIngredients(double cost) {
            this.cost = cost;
        }
    }

    private String customerName;
    private Pizza pizza;
    private List<Pizza> pizzaList = new ArrayList<>();
    private static long orderingNumber = 10000;
    private static long customerNumber = 0;

    private static PizzeriaPalmetto pizzeriaPalmetto = null;

    private PizzeriaPalmetto(){

    }

    //creates #PizzeriaPallmeto object in a singleton pattern
    public static PizzeriaPalmetto pizzeriaPalmettoFactory(){

        if(pizzeriaPalmetto == null){
            pizzeriaPalmetto = new PizzeriaPalmetto();
        }

        return pizzeriaPalmetto;
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }


    /**
     * take an order from customer interacting with them through console
     * method uses #Scanner and #System classes
     */
    public void orderPizza(Scanner scanner) {

        if (scanner == null) {
            System.out.println("Connection is failed");
            return;
        }


        String pizzaName = null;
        String pizzaType = null;
        int pizzaIngredients = 0;
        int pizzaQuantity = 0;

        try {

            System.out.println("\n\n        Welcome Pizzeria Palmetto \n");

            //get customer name
            System.out.println("Please enter your name");
            customerName = scanner.next();
            customerName = customerName.length() <= 15 ? customerName : customerName.substring(0, 14);

            //get pizza name
            System.out.println("Order a pizza with options below");
            System.out.println("Indicate the name of the pizza, it must be from four to twenty Latin letters, \n" +
                    "otherwise, the default name will be chosen");
            pizzaName = scanner.next();

            //get pizza type
            System.out.println("There are two types of pizza: regular 1.0$ and closed 1.5$ \n" +
                    "Please enter 1 if you want a closed-type pizza, otherwise, the pizza will be regular");
            int type = scanner.nextInt();
            pizzaType = type == 1 ? "closed" : "regular";

            //get ingredients as integer which is subject to further processing
            System.out.println("Please select the required ingredients by their serial number \n" +
                    "The maximum number of ingredients allowed is seven");
            int counter = 1;
            for (PizzaIngredients el : PizzaIngredients.values()) {
                System.out.println(counter++ + ": " + el + "-" + el.cost + "$");
            }
            pizzaIngredients = scanner.nextInt();

            //get quantity of pizza
            System.out.println("Please select the order quantity for pizza, the maximum possible quantity is ten");
            pizzaQuantity = scanner.nextInt();

            if (pizzaQuantity > 10) {
                throw new Exception();
            }

            createOrder(customerName, pizzaName, pizzaType, pizzaIngredients, pizzaQuantity);


        } catch (Exception ex) {
            System.out.println("\n\nPlease follow the instructions above!!");
            orderPizza(scanner);
        }


    }

    /**
     * create order using values obtained from console
     *
     * @param customerName
     * @param pizzaName
     * @param pizzaType
     * @param pizzaIngredients
     * @param pizzaQuantity
     */

    private void createOrder(String customerName, String pizzaName, String pizzaType, int pizzaIngredients, int pizzaQuantity) {

        Set<String> ingredients = createIngredientList(pizzaIngredients);
        String pizzaDefaultName = "Customer" + "_" + customerName + "_" + orderingNumber;

        pizza = new PizzaBuilder()
                .defaultName(pizzaDefaultName)
                .name(pizzaName)
                .type(pizzaType)
                .ingredientList(ingredients)
                .pizzaQuantity(pizzaQuantity)
                .build();

        orderingNumber++;
        customerNumber++;

        pizzaList.add(pizza);

    }

    /**
     * create set parsing integer obtained from console
     *
     * @param pizzaIngredients
     * @return
     */
    private Set<String> createIngredientList(int pizzaIngredients) {


        Set<String> ingredients = new HashSet<>(7);
        while (pizzaIngredients > 0) {
            int temp = pizzaIngredients % 10;
            pizzaIngredients /= 10;

            if (ingredients.size() >= 7) {
                break;
            }

            if (temp > 0 && temp <= 8) {

                switch (temp) {

                    case 1:
                        ingredients.add(PizzaIngredients.TOMATO_PASTE.name());
                        break;
                    case 2:
                        ingredients.add(PizzaIngredients.CHEESE.name());
                        break;
                    case 3:
                        ingredients.add(PizzaIngredients.SALAMI.name());
                        break;
                    case 4:
                        ingredients.add(PizzaIngredients.BACON.name());
                        break;
                    case 5:
                        ingredients.add(PizzaIngredients.GARLIC.name());
                        break;
                    case 6:
                        ingredients.add(PizzaIngredients.CORN.name());
                        break;
                    case 7:
                        ingredients.add(PizzaIngredients.PEPPERONI.name());
                        break;
                    case 8:
                        ingredients.add(PizzaIngredients.OLIVES.name());
                        break;
                    default:
                        break;
                }
            }
        }

        return ingredients;
    }

    //displays data about pizza
    public void display(Pizza pizza) {

        StringBuilder sb = new StringBuilder();
        sb
                .append("[")
                .append(orderingNumber)
                .append(": ")
                .append(customerNumber)
                .append(": ")
                .append(pizza.getName())
                .append(": ")
                .append(pizza.getPizzaQuantity())
                .append("]");

        System.out.println(sb);


    }

}
