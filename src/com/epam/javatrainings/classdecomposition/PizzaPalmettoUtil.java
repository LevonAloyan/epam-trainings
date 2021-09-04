package com.epam.javatrainings.classdecomposition;

import java.util.*;

public class PizzaPalmettoUtil {

    private static Order order;

    /**
     * create set parsing integer obtained from console
     *
     * @param pizzaIngredients
     * @return
     */
    public static Set<String> createIngredientList(int pizzaIngredients) {


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
                        ingredients.add(PizzeriaPalmetto.PizzaIngredients.TOMATO_PASTE.name());
                        break;
                    case 2:
                        ingredients.add(PizzeriaPalmetto.PizzaIngredients.CHEESE.name());
                        break;
                    case 3:
                        ingredients.add(PizzeriaPalmetto.PizzaIngredients.SALAMI.name());
                        break;
                    case 4:
                        ingredients.add(PizzeriaPalmetto.PizzaIngredients.BACON.name());
                        break;
                    case 5:
                        ingredients.add(PizzeriaPalmetto.PizzaIngredients.GARLIC.name());
                        break;
                    case 6:
                        ingredients.add(PizzeriaPalmetto.PizzaIngredients.CORN.name());
                        break;
                    case 7:
                        ingredients.add(PizzeriaPalmetto.PizzaIngredients.PEPPERONI.name());
                        break;
                    case 8:
                        ingredients.add(PizzeriaPalmetto.PizzaIngredients.OLIVES.name());
                        break;
                    default:
                        break;
                }
            }
        }

        return ingredients;
    }

    /**
     * generate default pizza name using customer name and
     * ordering number
     *
     * @param customerName
     * @param orderingNumber
     * @return
     */
    public static String pizzaDefaultNameGenerator(String customerName, long orderingNumber){
        StringBuilder sb = new StringBuilder();
        customerName = customerName.replace(" ","_");
        sb.append("Customer").append("_").append(customerName).append("_").append(orderingNumber);

        return sb.toString();

    }

    /**
     * create customer or update existing customer
     * add new order to customer's order list
     *
     * @param order
     * @param customers
     * @param customerPhoneNumber
     * @param customerName
     */
    public static void createCustomerOrUpdateExistingCustomer(
            Order order, Map<Long, Customer> customers,
            long customerPhoneNumber, String customerName){

        //add order to customer order's list.
        //if the customer is not yet in the customer list, they will be added.
        if (!customers.containsKey(customerPhoneNumber)){
            Customer customer = new Customer(customerPhoneNumber,customerName);
            customer.addOrderToCustomerOrderList(order);
            customers.put(customerPhoneNumber,customer);
        }else{
            Customer existingCustomer = customers.get(customerPhoneNumber);
            existingCustomer.addOrderToCustomerOrderList(order);
        }
    }

    /**
     * create new order or complement
     * already existing order
     *
     * @param pizza
     * @param orderingNumber
     * @param orderingFlag
     * @return
     */
    public static Order createOrComplementOrder(
            PizzaBuilder.Pizza pizza, long orderingNumber, int orderingFlag,int pizzaIndex) {

        if (orderingFlag == 1){
            order = new Order(orderingNumber);
            order.addPizzaToPizzaList(pizza);
        }else if (orderingFlag == 2){
            order.addPizzaToPizzaList(pizza);
        }else if (orderingFlag == 3){
            order.getPizzaList().set(pizzaIndex,pizza);
        }

        return order;
    }

    //add new ingredients to pizza
    public static PizzaBuilder.Pizza addIngredientsToPizza(PizzaBuilder.Pizza pizza, int ingredients) {
        Set<String> ingredientList = createIngredientList(ingredients);
        pizza.getIngredientList().addAll(ingredientList);
        return pizza;
    }

    //print check with customer, order and pizza data
    public static void printCheck(String customerName, long customerPhoneNumber, Order order) {
        System.out.println("************************************");
        System.out.println("Order: " + order.getOrderingNumber());
        System.out.println("Client: " + customerName);
        System.out.println("Phone: +374" + customerPhoneNumber);
        printPizzaData(order);
    }

    //complement pizza data to check
    private static void printPizzaData(Order order) {
        List<PizzaBuilder.Pizza> pizzaList = order.getPizzaList();

        double totalSum = 0;

        for (PizzaBuilder.Pizza pizza : pizzaList){
            double pizzaBaseCost = pizza.getType().equals("closed") ? 1.5 : 1.0;
            double sum = pizzaBaseCost;
            System.out.println("Name: " + pizza.getName());
            System.out.println("------------------------------------");
            System.out.println("Pizza base (" + pizza.getType() + ")" + " " + pizzaBaseCost + " $");

            Set<String> ingredients  = pizza.getIngredientList();
            for (PizzeriaPalmetto.PizzaIngredients el : PizzeriaPalmetto.PizzaIngredients.values()){

                if (ingredients.contains(el.name())){
                    System.out.println(el + " " + el.getCost() + " $");
                    sum += el.getCost();
                }
            }
            System.out.println("------------------------------------");
            System.out.println("Amount: " + sum + " $");
            System.out.println("Number: " + pizza.getPizzaQuantity());
            System.out.println("------------------------------------");

            totalSum += sum * pizza.getPizzaQuantity();

        }

        System.out.println("Total amount: " + totalSum + " $");

    }

    //create pizza
    public static PizzaBuilder.Pizza createPizza(
            int pizzaIngredients, String customerName,
            long orderingNumber, String pizzaName,
            String pizzaType, int pizzaQuantity) {

        //get ingredient list
        Set<String> ingredients = PizzaPalmettoUtil.createIngredientList(pizzaIngredients);
        //get default pizza name
        String pizzaDefaultName = PizzaPalmettoUtil.pizzaDefaultNameGenerator(customerName, orderingNumber);

        //create pizza
        PizzaBuilder.Pizza pizza = new PizzaBuilder()
                .defaultName(pizzaDefaultName)
                .name(pizzaName)
                .type(pizzaType)
                .ingredientList(ingredients)
                .pizzaQuantity(pizzaQuantity)
                .build();

        return pizza;
    }

    //show customer list
    public static void showCustomerList(Map<Long, Customer> customers) {
        System.out.println("Customer List *************************************************************");

        for (Map.Entry entry : customers.entrySet()){
            Customer customer = (Customer) entry.getValue();
            //print customer name and phone
            System.out.println("Name: " + customer.getName());
            System.out.println("Phone: +374" + customer.getPhone());
            //print customer order list
            System.out.println("Order List-----------------------------------------------------------------");
            List<Order> orderList = customer.getOrders();
            for(Order order : orderList){
                System.out.println();
                System.out.println("Order Number: " + order.getOrderingNumber());
                //print order pizza list
                System.out.println("Pizza List-----------------------------------------------------------------");
                List<PizzaBuilder.Pizza> pizzaList = order.getPizzaList();
                int count = 0;
                for (PizzaBuilder.Pizza pizza : pizzaList){
                    System.out.println(++count + ": ");
                    System.out.println("Pizza Name: " + pizza.getName());
                    System.out.println("Pizza Type: " + pizza.getType());
                    System.out.println("Pizza Ingredients: " + pizza.getIngredientList());
                    System.out.println("Pizza Quantity: " + pizza.getPizzaQuantity());
                }
            }

            System.out.println("****************************************************************************");
        }
    }

    //find and return last order number
    public static long getOrderingNumber(Map<Long, Customer> customers) {
        Customer customer = null;
        long orderingNumber = -1;
        Set<Map.Entry<Long, Customer>> set = customers.entrySet();
        Iterator<Map.Entry<Long, Customer>> iterator = set.iterator();
        while (iterator.hasNext()){
           customer = iterator.next().getValue();
        }
        if (customer != null){
            List<Order> orderList = customer.getOrders();
            Order order = orderList.get(orderList.size()-1);
            orderingNumber = order.getOrderingNumber() + 1;
        }

        return orderingNumber;

    }
}
