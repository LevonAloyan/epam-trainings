package com.epam.javatrainings.classdecomposition.pizzeria_palmetto.services;

import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.Ingredients;
import com.epam.javatrainings.classdecomposition.pizzeria_palmetto.model.Pizza;

public interface IngredientsCreator {
    boolean addIngredient(Ingredients ingredient, Pizza pizza);
}
