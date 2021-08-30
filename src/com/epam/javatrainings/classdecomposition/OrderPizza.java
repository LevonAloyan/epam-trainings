package com.epam.javatrainings.classdecomposition;

public class OrderPizza {
	private final Pizza pizza;
	private String name;
	private final int quantity;
	 
	public OrderPizza(Pizza pizza, int quantity) {
		this(pizza, "", quantity);
	}

	public OrderPizza(Pizza pizza, String name, int quantity) {
		this.pizza = pizza;
		this.name = name;
		this.quantity = quantity;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return pizza.getPrice();
	}

	public void print() {
		System.out.printf("Pizza_Type: %s, Name: %s, Quantity: %d \n", pizza.getPizzaType().toString(), name, quantity);
	}
}