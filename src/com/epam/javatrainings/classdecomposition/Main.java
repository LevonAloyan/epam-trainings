package com.epam.javatrainings.classdecomposition;
/**
 * @explain This is Pizzeria's driver class
 * Every time I created order obj for to set pizza list and get it, and most important for generate random non-repeating order number.
 * Random numbers for Customer is 4 digit and about order is 5.
 * Pizza name keep in the range. (greater 4 and no more than 20 Latin characters) else the pizza is named "customer_name_n". n in order number.
 * Both customer and order numbers are uniq.
 * I don't create method named printCheck(). I've overridden toString() method and how I understood it return data to JSON format.
 * Pizza Type and Ingredient I kept in Enums and also rates and use it from Pizza class for calculate the rate.
 * I don't use addIngredient() because its no need IN MY PROGRAM (I create set od Ingredients and put it in constructor). But I check size of it about >= 7 or duplicating.
 * @imThinking I don't use inheritance or interfaces, maybe I'm wrong, but I don't find need about these.
 * @author Erik Margaryan
 * @version 4.0.0
 * @since 2021.09.06
 */

import com.epam.javatrainings.classdecomposition.palmetto.Customer;
import com.epam.javatrainings.classdecomposition.palmetto.Order;
import com.epam.javatrainings.classdecomposition.palmetto.Pizza;
import com.epam.javatrainings.classdecomposition.palmetto.enums.Ingredient;
import com.epam.javatrainings.classdecomposition.palmetto.enums.Type;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Order order = new Order();
        Set<Ingredient> ingredients = Set.of(Ingredient.TOMATO_PASTE,
                Ingredient.PEPPERONI,
                Ingredient.GARLIC,
                Ingredient.BACON);
        Type type = Type.CALZONE;

        Pizza pizza = new Pizza(List.of(new Customer("Erik")),
                Order.getOrderNumber(),
                "Americano",
                type,
                ingredients);
        pizza.calculatePrice(ingredients, type, 3);
        order.setPizza(List.of(pizza));
        System.out.println(order.getPizza());


        Order anotherOrder = new Order();
        Set<Ingredient> anotherIngredients = Set.of(Ingredient.TOMATO_PASTE,
                Ingredient.CHEESE,
                Ingredient.SALAMI,
                Ingredient.OLIVES);
        Type anotherType = Type.REGULAR;
        Pizza anotherPizza = new Pizza(List.of(new Customer("Anahit")),
                Order.getOrderNumber(),
                "A",
                anotherType,
                anotherIngredients
        );
        anotherPizza.calculatePrice(anotherIngredients, anotherType, 12);
        anotherOrder.setPizza(List.of(anotherPizza));
        System.out.println(anotherOrder.getPizza());

/*
        //Test name length(). Test is work also constructor ( new (...) )
        anotherPizza.setName("AB");
        System.out.println("Test about length of name: " + anotherPizza.getName());
        anotherPizza.setName("ABCDE");
        System.out.println("Test about length of name: " + anotherPizza.getName());
*/
    }
}
