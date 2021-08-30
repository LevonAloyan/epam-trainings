package com.epam.javatrainings.classdecomposition;

public class Pizzeria {
	public static void main(String[] args) {
		Customer customer = new Customer("Margarita");

		Pizza pizza1 = new Pizza(PizzaType.REGULAR).ingredient(Ingredient.TOMATO_PASTE).
								   					ingredient(Ingredient.CHEESE).
								   					ingredient(Ingredient.BACON).
								   					ingredient(Ingredient.SALAMI);

		Pizza pizza2 = new Pizza(PizzaType.REGULAR).ingredient(Ingredient.OLIVES).
								   					ingredient(Ingredient.CHEESE).
								   					ingredient(Ingredient.PEPPERONI).
								   					ingredient(Ingredient.SALAMI);

		Pizza pizza3 = new Pizza(PizzaType.CALZONE).ingredient(Ingredient.OLIVES).
								   					ingredient(Ingredient.PEPPERONI).
								   					ingredient(Ingredient.CORN);

		OrderPizza orderPizza1 = new OrderPizza(pizza1, 3);
		OrderPizza orderPizza2 = new OrderPizza(pizza2, "Olivessalami", 2);
		OrderPizza orderPizza3 = new OrderPizza(pizza3, "Pepperonicorn", 4);

		Order order = new Order(customer);
		order.add(orderPizza1);
		order.add(orderPizza2);
		order.add(orderPizza3);

		order.printDetails();
	}
}