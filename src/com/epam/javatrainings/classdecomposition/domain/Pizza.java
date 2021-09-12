package com.epam.javatrainings.classdecomposition.domain;

import java.util.List;
import java.util.ArrayList;

public class Pizza {
	private final Type type;
	private final List<Ingredient> ingredients;

	public Pizza(Type type) {
		this.type = type;
		ingredients = new ArrayList<>();
	}

	public Type getType() {
		return type;
	}

	public List<Ingredient> getIngredients() {
		return new ArrayList<>(ingredients);
	}

	public Pizza add(Ingredient ingredient) {
		if(!ingredients.contains(ingredient)) {
			ingredients.add(ingredient);
		}
		return this;
	}

	public double calculatePrice() {
		double sum = 0.0;
		sum += type.getPrice();
		for(Ingredient ingredient : ingredients) {
			sum += ingredient.getPrice();
		}
		return sum;
	}
}