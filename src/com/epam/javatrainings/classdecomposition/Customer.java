package com.epam.javatrainings.classdecomposition;

public class Customer {
	private final long number;
	private final String name;

	public Customer(long number, String name) {
		this.number = number;
		this.name = name;
	}

	public long getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}
}