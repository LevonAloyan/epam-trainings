package com.epam.javatrainings.classdecomposition;

public class Customer {
	private static int count = 10000;

	private final int customerNumber;
	private final String name;

	public Customer(String name) {
		this.customerNumber = count++;
		this.name = name;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public String getName() {
		return name;
	}
}