package com.epam.javatrainings.classdecomposition;

import java.util.List;
import java.util.ArrayList;

public class Pizza {
	private final PizzaType pizzaType;
	private final List<Ingredient> ingredients;
	 

	public Pizza(PizzaType pizzaType) {
		this.pizzaType = pizzaType;
		ingredients = new ArrayList<>();
	}

	 
	public PizzaType getPizzaType() {
		return pizzaType;
	}


	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public Pizza ingredient(Ingredient ingredient) {
		if(!ingredients.contains(ingredient)) { 
			ingredients.add(ingredient);
		}
		return this;
	}

	public double getPrice() {
		double sum = 0.0;
		sum += pizzaType.getPrice();
		for(Ingredient ingredient : ingredients) {
			sum += ingredient.getPrice();
		}
		return sum;
	}
}