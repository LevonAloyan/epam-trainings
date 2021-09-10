package com.epam.javatrainings.classdecomposition;

import java.util.List;
import java.util.ArrayList;

public class Pizza {
	private Type type;
	private String name;
	private int quantity;
	private List<Ingredient> ingredients;	 

	public Pizza(Type type, String name, int quantity) {
		this.type = type;
		this.name = name;
		this.quantity = quantity;
		ingredients = new ArrayList<>();
	}

	 
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
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

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public List<Ingredient> getIngredients() {
		return new ArrayList<>(ingredients);
	}

	public boolean addIngredient(Ingredient ingredient) {
		if(!ingredients.contains(ingredient)) { 
			ingredients.add(ingredient);
			return true;
		}
		return false;
	}

	public boolean removeIngredinet(Ingredient ingredient) {
		return ingredients.remove(ingredient);
	}

	public double calculatePrice() {
		double sum = 0.0;
		sum += type.getPrice();
		for(Ingredient ingredient : ingredients) {
			sum += ingredient.getPrice();
		}
		return sum * quantity;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n--------------------------------\n");
		sb.append("Name: " + name + "\n");
		sb.append("--------------------------------\n");
		sb.append("Pizza base (" + type.getName() + ") " + type.getPrice() + "$\n");
		for(Ingredient ingredient : ingredients) {
			sb.append(ingredient.getName() + " " + ingredient.getPrice() + "$\n");
		}
		sb.append("--------------------------------\n");
		sb.append("Price: " + calculatePrice() + "$\n");
		sb.append("Quantity: " + quantity + "\n");
		return sb.toString();
	}
}