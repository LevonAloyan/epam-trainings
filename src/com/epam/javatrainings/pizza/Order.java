package com.epam.javatrainings.pizza;

import com.epam.javatrainings.pizza.dto.CustomerDto;
import com.epam.javatrainings.pizza.util.GlobalValidator;

import java.time.LocalDate;
import java.util.List;

public class Order {

    public static void main(String[] args) {

        Customer customer1 = new Customer("John Doe", 7544);

        PizzaOrder basket = new PizzaOrder(customer1);

        Pizza margarita = new RegularPizza();
        margarita.setName("Margarita");
        margarita.setQuantity(3);
        margarita.addIngredient(Ingredient.BACON);
        margarita.addIngredient(Ingredient.TOMATO_PASTE);
        margarita.addIngredient(Ingredient.PEPPERONI);
        margarita.addIngredient(Ingredient.GARLIC);

        Pizza calzone = new Calzone();
        calzone.setName("Calzone");
        calzone.setQuantity(2);
        calzone.addIngredient(Ingredient.CHEESE);
        calzone.addIngredient(Ingredient.TOMATO_PASTE);
        calzone.addIngredient(Ingredient.SALAMI);
        calzone.addIngredient(Ingredient.OLIVES);

        basket.addPizza(margarita);
        basket.addPizza(calzone);

        basket.printCheck();

        CustomerDto dto = new CustomerDto("John Doe", "JD@mail.com", LocalDate.of(1984,10,9), 30);
        GlobalValidator.validate(dto);
        List<String> errorMessages = GlobalValidator.getErrorMessages();
        for(String s:errorMessages) {
            System.out.println(s);
        }

//        System.out.println("Total price for order -> N" + basket.orderNumber() + " is : " + basket.calculateTotalPrice() + " $");
    }

}
