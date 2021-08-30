package com.epam.javatrainings.classdecomposition;

public enum PizzaType {
	REGULAR(1), CALZONE(1.5);

	private final double price;

	private PizzaType(double price) {
		this.price =price;
	}

	public double getPrice() {
		return price;
	}
} 