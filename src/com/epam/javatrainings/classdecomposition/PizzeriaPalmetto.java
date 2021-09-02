package com.epam.javatrainings.classdecomposition;

import java.util.*;


public class PizzeriaPalmetto {

    public enum PizzaIngredients {
        TOMATO_PASTE(1.0), CHEESE(1.0), SALAMI(1.5),
        BACON(1.2), GARLIC(0.3), CORN(0.7), PEPPERONI(0.6), OLIVES(0.5);

        private double cost;

        public double getCost() {
            return cost;
        }

        PizzaIngredients(double cost) {
            this.cost = cost;
        }
    }

    private static int orderingFlag = 1;
    private String customerName;
    private long customerPhoneNumber;
    private PizzaBuilder.Pizza pizza;
    private final List<Order> orderList = new ArrayList<>();
    private final Map<Long, Customer> customers = new HashMap<>();
    private static long orderingNumber = 10000;

    private static PizzeriaPalmetto pizzeriaPalmetto = null;

    private PizzeriaPalmetto() {

    }

    //creates #PizzeriaPallmeto object in a singleton pattern
    public static PizzeriaPalmetto pizzeriaPalmettoFactory() {

        if (pizzeriaPalmetto == null) {
            pizzeriaPalmetto = new PizzeriaPalmetto();
        }

        return pizzeriaPalmetto;
    }

    public Map<Long, Customer> getCustomers() {
        return customers;
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
        UserInterface userInterface = UserInterface.userInterfaceFactory(scanner);

        String pizzaName = null;
        String pizzaType = null;
        int pizzaIngredients = 0;
        int pizzaQuantity = 0;
        int choice = 0;

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

        //check if the order is completed or not
        choice = userInterface.makeChoice();


        while (choice <= 3) {
            if (choice == 1) {
                //create order
                createOrder(
                        customerName, customerPhoneNumber, pizzaName, pizzaType,
                        pizzaIngredients, pizzaQuantity, choice);
                break;

            } else if (choice == 2) {
                //create order
                createOrder(
                        customerName, customerPhoneNumber, pizzaName, pizzaType,
                        pizzaIngredients, pizzaQuantity, choice);
                //complement order
                complementOrder(userInterface);
                break;

            } else if (choice == 3) {
                //create order
                createOrder(
                        customerName, customerPhoneNumber, pizzaName, pizzaType,
                        pizzaIngredients, pizzaQuantity, choice);

                //change order
                choice = changeOrder(userInterface);
            }
        }
    }

    /**
     * complement order
     *
     * @param userInterface
     */
    private void complementOrder(UserInterface userInterface) {
        String pizzaName = null;
        String pizzaType = null;
        int pizzaIngredients = 0;
        int pizzaQuantity = 0;
        int choice = 0;

        //get pizza name
        pizzaName = userInterface.getPizzaName();

        //get pizza type
        pizzaType = userInterface.getPizzaType();

        //get pizza ingredients
        pizzaIngredients = userInterface.getIngredients();

        //get pizza quantity
        pizzaQuantity = userInterface.getPizzaQuantity();

        //check if the order is completed or not
        choice = userInterface.makeChoice();

        while (choice <= 3) {
            if (choice == 1) {
                //create order
                createOrder(
                        customerName, customerPhoneNumber, pizzaName, pizzaType,
                        pizzaIngredients, pizzaQuantity, choice);
                break;
            } else if (choice == 2) {
                //create order
                createOrder(
                        customerName, customerPhoneNumber, pizzaName, pizzaType,
                        pizzaIngredients, pizzaQuantity, choice);
                //complement order
                complementOrder(userInterface);
                break;

            } else if (choice == 3) {
                //create order
                createOrder(
                        customerName, customerPhoneNumber, pizzaName, pizzaType,
                        pizzaIngredients, pizzaQuantity, choice);

                //change order
                choice = changeOrder(userInterface);

            }
        }


    }

    /**
     * create order using values obtained from console
     *
     * @param customerName
     * @param customerPhoneNumber
     * @param pizzaName
     * @param pizzaType
     * @param pizzaIngredients
     * @param pizzaQuantity
     * @param choice
     */

    private void createOrder(String customerName, long customerPhoneNumber,
                             String pizzaName, String pizzaType, int pizzaIngredients,
                             int pizzaQuantity, int choice) {

        Order order;

        //create pizza
        pizza = PizzaPalmettoUtil.createPizza(
                pizzaIngredients,customerName,orderingNumber,
                pizzaName,pizzaType,pizzaQuantity);

        //create or complement order
        order = PizzaPalmettoUtil.createOrComplementOrder(pizza, orderingNumber, orderingFlag, 0);
        orderingFlag = 0;

        //increase ordering number
        if (choice == 1) {
            //create new customer or update already existing
            //customer. add new customer to customer list
            //also add order to customer order's list
            PizzaPalmettoUtil.createCustomerOrUpdateExistingCustomer(
                    order, customers, customerPhoneNumber,
                    customerName);
            PizzaPalmettoUtil.printCheck(customerName, customerPhoneNumber, order);
            orderingFlag = 1;
            orderingNumber++;
        } else if (choice == 2) {
            orderingFlag = 2;
        }
        //add pizza to pizza list
        orderList.add(order);

    }

    //change the order (add new ingredients to pizza ingredient's list)
    public int changeOrder(UserInterface userInterface) {
        int ingredients;
        int pizzaIndex;
        Order order;
        order = getCurrentOrder();
        pizzaIndex = userInterface.showCurrentOrder(order);
        if (pizzaIndex < 0) {
            return userInterface.makeChoice();
        }
        PizzaBuilder.Pizza pizza = order.getPizzaList().get(pizzaIndex);
        ingredients = userInterface.addIngredients(pizza);
        //add ingredients to chosen pizza
        addIngredients(ingredients, pizzaIndex, pizza);

        return userInterface.makeChoice();
    }

    //add new ingredients to chosen pizza
    private void addIngredients(int ingredients, int pizzaIndex, PizzaBuilder.Pizza pizza) {
        pizza = PizzaPalmettoUtil.addIngredientsToPizza(pizza, ingredients);
        Order order =
                PizzaPalmettoUtil.createOrComplementOrder(pizza, orderingNumber, 3, pizzaIndex);
        PizzaPalmettoUtil.createCustomerOrUpdateExistingCustomer(order, customers, customerPhoneNumber, customerName);
    }


    //obtain current order from customer order list
    private Order getCurrentOrder() {
        return orderList.get(orderList.size() - 1);
    }


}
