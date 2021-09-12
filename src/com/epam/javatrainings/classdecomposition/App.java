package com.epam.javatrainings.classdecomposition;

import com.epam.javatrainings.classdecomposition.domain.*;
import com.epam.javatrainings.classdecomposition.util.generator.CustomerNumberGenerator;
import com.epam.javatrainings.classdecomposition.util.generator.OrderNumberGenerator;

public class App {
	public static void main(String[] args) {
		Customer customer = new Customer(CustomerNumberGenerator.next(), "John");
		Order order = new Order(OrderNumberGenerator.next(), customer);

		order.createPizza(Type.CALZONE)
				.add(Ingredient.BACON)
				.add(Ingredient.CHEESE)
				.add(Ingredient.CORN);

		order.add(4);

		order.createPizza(Type.REGULAR)
				.add(Ingredient.OLIVES)
				.add(Ingredient.PEPPERONI)
				.add(Ingredient.TOMATO_PASTE)
				.add(Ingredient.SALAMI);

		order.add(2, "Pizzerita");

		printCheck(order);
	}
 
	public static void printCheck(Order order) {
		System.out.println(order);
	}
}
