package com.epam.javatrainings.classdecomposition.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Order {
	private final long number;
	private final Customer customer;
	private final List<OrderPizza> pizzaList;
	private LocalDate date;

	private Pizza current;
	private boolean allow = false;

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

	public Pizza createPizza(Type type) {
		current = new Pizza(type);
		allow = true;
		return current;
	}

	public boolean add(int quantity) {
		String name = "Customer_" + customer.getName().toLowerCase()+ "_" + (pizzaList.size() + 1);
		return add(quantity, name);
	}

	public boolean add(int quantity, String name) {
		if(!isAllow()) {
			System.out.println("List is full or noting to add");
			return false;
		}
		OrderPizza orderPizza = new OrderPizza(current, quantity, name);
		allow = false;
		return pizzaList.add(orderPizza);
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
		sb.append("\n--------------------------------\n");
		sb.append("Total price: ").append(getTotalPrice()).append("$\n");
		sb.append("Order date: ").append(date).append("\n");
		sb.append("********************************\n");
		return sb.toString();	 
	}

	private boolean isAllow() {
		return allow && pizzaList.size() <= 10;
	}
}