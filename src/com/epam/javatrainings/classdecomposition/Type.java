package com.epam.javatrainings.classdecomposition;

public enum Type {
	REGULAR("Regular", 1),
	CALZONE("Calzone", 1.5);

	private final String name;
	private final double price;

	private Type(String name, double price) {
		this.name = name;
		this.price =price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
} 