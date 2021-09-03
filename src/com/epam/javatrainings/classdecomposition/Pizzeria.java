package com.epam.javatrainings.classdecomposition;

public class Pizzeria {
	public static void main(String[] args) {
		Customer adam = new Customer("Adam");

<<<<<<< HEAD
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
=======
		Pizza pizza1 = new Pizza(PizzaType.REGULAR).ingredient(Ingredient.TOMATO_PASTE)
						           .ingredient(Ingredient.CHEESE)
							   .ingredient(Ingredient.BACON)
							   .ingredient(Ingredient.SALAMI);

		Pizza pizza2 = new Pizza(PizzaType.REGULAR).ingredient(Ingredient.OLIVES)
							   .ingredient(Ingredient.CHEESE)
						           .ingredient(Ingredient.PEPPERONI)
							   .ingredient(Ingredient.SALAMI);

		Pizza pizza3 = new Pizza(PizzaType.CALZONE).ingredient(Ingredient.OLIVES).
							   .ingredient(Ingredient.PEPPERONI).
							   .ingredient(Ingredient.CORN);

		OrderPizza orderPizza1 = new OrderPizza(pizza1, 3);
		OrderPizza orderPizza2 = new OrderPizza(pizza2, "Olivessalami", 2);
		OrderPizza orderPizza3 = new OrderPizza(pizza3, "Pepperonicorn", 4);

		Order order = new Order(customer);
		order.add(orderPizza1);
		order.add(orderPizza2);
		order.add(orderPizza3);
>>>>>>> 859d5b20946e1527919d84130f8ae12e038f3363

	public static void printCheck(Order order) {
		System.out.println(order);
	}
}
