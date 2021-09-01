package com.epam.javatrainings.classdecomposition;

import java.util.*;


public class PizzeriaPalmetto {

    public enum PizzaIngredients {
        TOMATO_PASTE(1.0), CHEESE(1.0), SALAMI(1.5),
        BACON(1.2), GARLIC(0.3), CORN(0.7), PEPPERONI(0.6), OLIVES(0.5);

        private double cost;

        public double getCost(){
            return cost;
        }

        PizzaIngredients(double cost) {
            this.cost = cost;
        }
    }

    private UserInterface userInterface;
    private String customerName;
    private long customerPhoneNumber;
    private PizzaBuilder.Pizza pizza;
    private List<PizzaBuilder.Pizza> pizzaList = new ArrayList<>();
    private Map<Long,Customer> customers = new HashMap<>();
    private static long orderingNumber = 10000;

    public Map<Long, Customer> getCustomers() {
        return customers;
    }


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

    public List<PizzaBuilder.Pizza> getPizzaList() {
        return pizzaList;
    }


    /**
     * take an order from customer interacting with them through console
     * method uses #Scanner and #System classes
     */
    public void orderPizza(Scanner scanner) {

        System.out.println("\n\n        Welcome Pizzeria Palmetto \n");

        //check connection
        if (scanner == null) {
            System.out.println("Connection is failed");
        }
        //create user interface instance in singleton pattern
        userInterface = UserInterface.userInterfaceFactory(scanner);

        String pizzaName = null;
        String pizzaType = null;
        int pizzaIngredients = 0;
        int pizzaQuantity = 0;

            //get customer name
            customerName = userInterface.getCustomerName();

            //get customer phone number
            customerPhoneNumber = userInterface.getCustomerPhoneNumber();

            //get pizza name
            pizzaName = userInterface.getPizzaName();

            //get pizza type
            pizzaType = userInterface.getPizzaType();

            //get ingredients as integer which is subject to further processing
            pizzaIngredients = userInterface.getIngredients();

            //get quantity of pizza
            pizzaQuantity = userInterface.getPizzaQuantity();

            //create order
            createOrder(customerName,customerPhoneNumber, pizzaName, pizzaType, pizzaIngredients, pizzaQuantity);

    }

    /**
     * create order using values obtained from console
     *  @param customerName
     * @param customerPhoneNumber
     * @param pizzaName
     * @param pizzaType
     * @param pizzaIngredients
     * @param pizzaQuantity
     */

    private void createOrder(String customerName, long customerPhoneNumber, String pizzaName, String pizzaType, int pizzaIngredients, int pizzaQuantity) {

        //get ingredient list
        Set<String> ingredients = PizzaPalmettoUtil.createIngredientList(pizzaIngredients);
        //get default pizza name
        String pizzaDefaultName = PizzaPalmettoUtil.pizzaDefaultNameGenerator(customerName,orderingNumber);

        //create pizza
        pizza = new PizzaBuilder()
                .defaultName(pizzaDefaultName)
                .name(pizzaName)
                .type(pizzaType)
                .ingredientList(ingredients)
                .pizzaQuantity(pizzaQuantity)
                .build();

        //create order and add to customer's order list
        //if the customer isn't in customer list create
        //new customer and customer list
        PizzaPalmettoUtil.createOrderAndAddToCustomerOrderList(
                pizza,orderingNumber,customers,customerPhoneNumber,
                customerName);

        //increase ordering number
        orderingNumber++;
        //add pizza to pizza list
        pizzaList.add(pizza);

    }


    public void addIngredient(){

    }

    //displays data about pizza
    public void display(PizzaBuilder.Pizza pizza) {

        StringBuilder sb = new StringBuilder();
        sb
                .append("[")
                .append(orderingNumber)
                .append(": ")
                .append(customerPhoneNumber)
                .append(": ")
                .append(pizza.getName())
                .append(": ")
                .append(pizza.getPizzaQuantity())
                .append("]");

        System.out.println(sb);


    }

}
