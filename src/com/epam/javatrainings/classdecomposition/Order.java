package com.epam.javatrainings.classdecomposition;

import java.util.List;
import java.util.ArrayList;

public class Order {
	private static int numGen = 10000;

	private final int orderNumber;
	private final Customer customer;
	private List<Pizza> pizzaList;

	public Order(Customer customer) {
		orderNumber = numGen++;
		this.customer = customer;
		pizzaList = new ArrayList<>();
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<Pizza> getPizzaList() {
		return new ArrayList<>(pizzaList);
	}

	public boolean addPizza(Pizza pizza) {
		if(pizzaList.size() == 10) {
			System.out.println("No more than 10 items can be order");
			return false;
		}
		return pizzaList.add(pizza);
	}

	public boolean removePizza(Pizza pizza) {
		return pizzaList.remove(pizza);
	}

	public double getTotalPrice() {
		double sum = 0.0;
		for(Pizza pizza : pizzaList) {
			sum += pizza.calculatePrice();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("********************************\n");
		sb.append("Order: " + orderNumber + "\n");
		sb.append("Customer: " + customer.getCustomerNumber() + "\n");
		sb.append("Name: " + customer.getName() + "\n");
		for(Pizza pizza : pizzaList) {
			sb.append(pizza.toString());
		}
		sb.append("\n--------------------------------\n");
		sb.append("Total price: " + getTotalPrice() + "$\n");
		sb.append("********************************\n");
		return sb.toString();	 
	}
}