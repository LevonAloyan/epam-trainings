package com.epam.javatrainings.classdecomposition;

public class Customer {
	private static int numGen = 10000;

	private final int customerNumber;
	private String name;

	public Customer(String name) {
		this.customerNumber = numGen++;
		this.name = name;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}