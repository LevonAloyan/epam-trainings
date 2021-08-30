package com.epam.javatrainings.classdecomposition;

import java.util.List;
import java.util.ArrayList;

public class Order {
	private static int count = 10000;

	private final int orderNumber;
	private final Customer customer;
	private List<OrderPizza> list;

	public Order(Customer customer) {
		orderNumber = count++;
		this.customer = customer;
		list = new ArrayList<>();
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<OrderPizza> getList() {
		return new ArrayList<>(list);
	}

	public boolean add(OrderPizza orderPizza) {
		if(list.size() == 10) {
			System.out.println("No more than 10 items can be order");
			return false;
		}

		String name = orderPizza.getName();
		if(name.length() < 4 || name.length() > 20) {
			orderPizza.setName(customer.getCustomerNumber() + "_" + customer.getName() + "_" + (list.size() + 1));
		}
		return list.add(orderPizza);
	}

	public double getTotalPrice() {
		double sum = 0.0;
		for(OrderPizza orderPizza : list) {
			sum += orderPizza.getPrice();
		}
		return sum;
	}

	public void printDetails() {
		System.out.printf("Order_Number: %d, Customer_Number: %d, Customer_Name: %s \n", orderNumber, 
			customer.getCustomerNumber(), customer.getName());
		for(int i = 0; i < list.size(); i++) {
			System.out.printf("%d: ", (i+1));
			list.get(i).print();
		}
		System.out.println("\nTotal_Price: " + getTotalPrice());
	}
}