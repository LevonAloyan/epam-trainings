package com.epam.javatrainings.classdecomposition;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class PizzeriaPalmetto {

    public enum PizzaIngredients {
        TOMATO_PASTE(1.0), CHEESE(1.0), SALAMI(1.5),
        BACON(1.2), GARLIC(0.3), CORN(0.7), PEPPERONI(0.6), OLIVES(0.5);

        private final double cost;

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
    private final List<Order> orderList = new ArrayList<>();
    private static Map<Long, Customer> customers = new LinkedHashMap<>();
    private static long orderingNumber = 10000;
    private static UserInterface userInterface;
    private static Scanner scanner = null;

    private static PizzeriaPalmetto pizzeriaPalmetto = null;

    private PizzeriaPalmetto() {
    }

    private static void init() {
        //initialize scanner
        scanner = new Scanner(System.in);
        //create user interface instance in singleton pattern
        userInterface = UserInterface.userInterfaceFactory(scanner);
        //get data from customer.txt file and init customer list
        customers = DataStore.read();
        orderingNumber = PizzaPalmettoUtil.getOrderingNumber(customers);

    }

    //creates #PizzeriaPallmeto object in a singleton pattern
    public static PizzeriaPalmetto pizzeriaPalmettoFactory() {

        if (pizzeriaPalmetto == null) {
            pizzeriaPalmetto = new PizzeriaPalmetto();
            init();
        }

        return pizzeriaPalmetto;
    }


    public static long getOrderingNumber() {
        return orderingNumber;
    }


    /**
     * take an order from customer interacting with them through console
     * method uses #Scanner and #System classes
     */
    public void orderPizza() {

        System.out.println("\n\n**********************************************");
        System.out.println("        Welcome Pizzeria Palmetto \n");

        String pizzaName;
        String pizzaType;
        int pizzaIngredients;
        int pizzaQuantity;
        int choice;

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

        //complete, complement or change order
        controlOrder(choice, pizzaName, pizzaType, pizzaIngredients, pizzaQuantity);
    }

    /**
     * complement order
     *
     * @param userInterface
     */
    private void complementOrder(UserInterface userInterface) {
        String pizzaName;
        String pizzaType;
        int pizzaIngredients;
        int pizzaQuantity;
        int choice;

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

        //complete, complement or change order
        controlOrder(choice, pizzaName, pizzaType, pizzaIngredients, pizzaQuantity);


    }

    //complete, complement or change order
    private void controlOrder(int choice, String pizzaName, String pizzaType, int pizzaIngredients, int pizzaQuantity) {

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
                choice = changeOrder();

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
        PizzaBuilder.Pizza pizza = PizzaPalmettoUtil.createPizza(
                pizzaIngredients, customerName, orderingNumber,
                pizzaName, pizzaType, pizzaQuantity);

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
            //print order check
            PizzaPalmettoUtil.printCheck(customerName, customerPhoneNumber, order);
            orderingFlag = 1;
            orderingNumber++;
            //quit or complete another order
            quitApp();
        } else if (choice == 2) {
            orderingFlag = 2;
        }
        //add pizza to pizza list
        orderList.add(order);

    }

    //new order or quit app
    private void quitApp() {
        int choice;
        choice = userInterface.quitApp();
        orderList.clear();
        if (choice == 1) {
            orderPizza();
        } else if (choice == 3) {
            showPizzaPalmettoDatabase();
            quitApp();
        } else {
            //write customer list to customers.txt file
            DataStore.write(customers);
            System.out.println("Thanks for purchasing.\n" +
                    "Have a nice day.");
            //close scanner
            if (scanner != null) {
                scanner.close();
            }
            //close the app
            System.exit(0);

        }
    }

    //change the order (add new ingredients to pizza ingredient's list)
    private int changeOrder() {
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
        PizzaPalmettoUtil.addIngredientsToPizza(pizza, ingredients);
        PizzaPalmettoUtil.createOrComplementOrder(pizza, orderingNumber, 3, pizzaIndex);
    }


    //obtain current order from customer order list
    private Order getCurrentOrder() {
        return orderList.get(orderList.size() - 1);
    }

    //display Pizza Palmetto database
    private static void showPizzaPalmettoDatabase() {
        System.out.println("\n\n        Pizza Palmetto Database\n");
        PizzaPalmettoUtil.showCustomerList(customers);
    }


}
