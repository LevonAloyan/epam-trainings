package com.epam.javatrainings.classdecomposition;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PizzaPalmettoUtil {

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

    public static String pizzaDefaultNameGenerator(String customerName, long orderingNumber){
        StringBuilder sb = new StringBuilder();
        customerName = customerName.replace(" ","_");
        sb.append("Customer").append("_").append(customerName).append("_").append(orderingNumber);

        return sb.toString();

    }

    public static void createOrderAndAddToCustomerOrderList(
            PizzaBuilder.Pizza pizza, Long orderingNumber,
            Map<Long, Customer> customers, long customerPhoneNumber,
            String customerName){

        //creates order and customer, adds order to customer order's list.
        //if the customer is not yet in the customer list, they will be added.
        Order order = new Order(pizza,orderingNumber);

        if (!customers.containsKey(customerPhoneNumber)){
            Customer customer = new Customer(customerPhoneNumber,customerName);
            customer.addOrderToCustomerOrderList(order);
            customers.put(customerPhoneNumber,customer);
        }else{
            Customer existingCustomer = customers.get(customerPhoneNumber);
            existingCustomer.addOrderToCustomerOrderList(order);
        }
    }
}
