package com.epam.javatrainings.classdecomposition;

public class Service {

    public static void validatePizzaName(String pizzaName) {
        Order order = new Order();
        if (pizzaName.length() > 3 && pizzaName.length() < 21) {
            for (String name : Pizza.getPizzaName()) {
                if (name.equals(pizzaName)) {
                    System.out.println("You choose pizza: " + pizzaName + ", " + order.getOrderNumber());
                } else {
                    System.out.println("Special for you: " + Customer.getCustomerName() + ", "
                            + order.getOrderNumber());
                }
                break;
            }
        } else {
            System.out.println("Wrong name: " + Customer.getCustomerName() + " :" + order.getOrderNumber());
        }
    }
}
