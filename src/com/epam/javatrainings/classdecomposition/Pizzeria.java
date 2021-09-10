package com.epam.javatrainings.classdecomposition;

public class Pizzeria {
	public static void main(String[] args) {
		Customer adam = new Customer("Adam");

		Pizza margarita = new Pizza(Type.CALZONE, "Margarita", 2);
		margarita.addIngredient(Ingredient.TOMATO_PASTE);
		margarita.addIngredient(Ingredient.PEPPERONI);
		margarita.addIngredient(Ingredient.GARLIC);
		margarita.addIngredient(Ingredient.BACON);
		 
		Pizza pepperoniOro = new Pizza(Type.REGULAR, "PepperoniOro", 3);
		pepperoniOro.addIngredient(Ingredient.TOMATO_PASTE);
		pepperoniOro.addIngredient(Ingredient.PEPPERONI);
		pepperoniOro.addIngredient(Ingredient.CHEESE);
		pepperoniOro.addIngredient(Ingredient.OLIVES);

		Order adamsOrder = new Order(adam);
		adamsOrder.addPizza(margarita);
		adamsOrder.addPizza(pepperoniOro);

		printCheck(adamsOrder); 
	}
 
	public static void printCheck(Order order) {
		System.out.println(order);
	}
}
