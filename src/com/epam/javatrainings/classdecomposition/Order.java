package com.epam.javatrainings.classdecomposition;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Order {
	private final long number;
	private final Customer customer;
	private final List<OrderPizza> pizzaList;
	private final LocalDate date;

	public Order(long number, Customer customer) {
		this.number = number;
		this.customer = customer;
		pizzaList = new ArrayList<>();
		this.date = LocalDate.now();
	}

	public long getNumber() {
		return number;
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<OrderPizza> getPizzaList() {
		return new ArrayList<>(pizzaList);
	}

	public boolean addPizza(Pizza pizza, int quantity) {
		String name = "Customer_" + customer.getName().toLowerCase()+ "_" + (pizzaList.size() + 1);
		return addPizza(pizza, quantity, name);
	}

	public boolean addPizza(Pizza pizza, int quantity, String name) {
		if(isFull()) {
			System.out.println("Order list is full");
			return false;
		}

		OrderPizza orderPizza = new OrderPizza(pizza, quantity, name);
		return pizzaList.add(orderPizza);
	}

	private boolean isFull() {
		return pizzaList.size() >= 10;
	}

	public double getTotalPrice() {
		double sum = 0.0;
		for(OrderPizza orderPizza :pizzaList) {
			sum += orderPizza.calculatePrice();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("********************************\n");
		sb.append("Order: ").append(number).append("\n");
		sb.append("Customer_ID: ").append(customer.getNumber()).append("\n");
		sb.append("Customer_Name: ").append(customer.getName()).append("\n");
		for(OrderPizza orderPizza : pizzaList) {
			sb.append(orderPizza.toString());
		}
		sb.append("--------------------------------\n");
		sb.append("Total price: ").append(getTotalPrice()).append("$\n");
		sb.append("Order date: ").append(date).append("\n");
		sb.append("********************************\n");
		return sb.toString();	 
	}
}