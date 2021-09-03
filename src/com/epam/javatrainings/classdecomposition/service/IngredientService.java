package com.epam.javatrainings.classdecomposition.service;

import com.epam.javatrainings.classdecomposition.persistance.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IngredientService {
    public static List<Ingredient> addPizzasIngredient(Ingredient ingredient){
        List<Ingredient> ingredients = new ArrayList<>();
        checkDuplicateIngredient(ingredient,ingredients);
        return ingredients;
    }

    public static double calculatePizzasIngredientsCost(List<Ingredient> ingredients){
        double pizzasIngredientsCost = 0;
        for (Ingredient ingredient : ingredients) {
            pizzasIngredientsCost += ingredient.getCost();
        }
        return pizzasIngredientsCost;
    }

    public static void printPizzasIngredients(List<Ingredient> ingredients){
        for (Ingredient ingredient : ingredients) {
            System.out.println(ingredient.getName() + " " + ingredient.getCost() + " €");
        }
    }

    public static double checkIngredientFixedCost(String name) {
        List<String> ingredientNames = new ArrayList<>(Arrays.asList("Tomato paste", "Cheese", "Salami", "Bacon", "Garlic", "Corn", "Pepperoni", "Olives"));
        List<Double> ingredientFixedCosts = new ArrayList<>(Arrays.asList(1.0,1.0,1.5,1.2,0.3,0.7,0.6,0.5));
        int ingredientFixedCostIndex = -1;
        for (int i = 0; i < ingredientNames.size(); i++) {
            if (name.toLowerCase().equals(ingredientNames.get(i).toLowerCase())){
                ingredientFixedCostIndex = i;
                break;
            }
        }

        double ingredientCost = 1;
        if (ingredientFixedCostIndex >= 0){
            ingredientCost = ingredientFixedCosts.get(ingredientFixedCostIndex);
        }

        return ingredientCost;
    }

    private static void checkDuplicateIngredient(Ingredient ingredient,List<Ingredient> ingredients){
        for (Ingredient ing : ingredients) {
            if (ingredient.equals(ing)){
                System.out.println("Please check the order again");
                break;
            }ingredients.add(ingredient);
        }
    }

    private static void checkFullPizza(List<Ingredient> ingredients){
        if (ingredients.size() == 7){
            System.out.println("Full Pizza");
        }
    }
}
