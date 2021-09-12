package com.epam.javatrainings.classdecomposition;

import com.epam.javatrainings.classdecomposition.generator.CustomerNumberGenerator;
import com.epam.javatrainings.classdecomposition.generator.OrderNumberGenerator;

public class Pizzeria {
	public static void main(String[] args) {
		Customer customer = new Customer(CustomerNumberGenerator.next(), "John");
		Order order = new Order(OrderNumberGenerator.next(), customer);

		Pizza pizza = new Pizza(Type.CALZONE);
		pizza.addIngredient(Ingredient.TOMATO_PASTE);
		pizza.addIngredient(Ingredient.CHEESE);
		pizza.addIngredient(Ingredient.PEPPERONI);

		order.addPizza(pizza, 3, "Margarita");

		pizza = new Pizza(Type.REGULAR);
		pizza.addIngredient(Ingredient.TOMATO_PASTE);
		pizza.addIngredient(Ingredient.BACON);
		pizza.addIngredient(Ingredient.SALAMI);
		pizza.addIngredient(Ingredient.OLIVES);

		order.addPizza(pizza, 4);

		printCheck(order);
	}
 
	public static void printCheck(Order order) {
		System.out.println(order);
	}
}
