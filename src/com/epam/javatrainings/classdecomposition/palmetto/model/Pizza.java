package com.epam.javatrainings.classdecomposition.palmetto.model;

import com.epam.javatrainings.classdecomposition.palmetto.model.Ingredients.Ingredient;

import java.util.ArrayList;
import java.util.Objects;

public class Pizza {
    private String name;
    private float cost;
    private boolean calzone;
    private ArrayList<Ingredient> ingredients;

    public Pizza(boolean calzone) {
        this.calzone = calzone;
        ingredients=new ArrayList<>();
        if (calzone) this.cost = 1.5F;
        else this.cost = 1F;
    }

    public Pizza(String name, boolean calzone) {

        this.calzone = calzone;
        this.name= name;
        ingredients=new ArrayList<>();
        if (calzone) this.cost = 1.5F;
        else this.cost = 1F;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", calzone=" + calzone +
                ", ingredients=" + ingredients +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pizza)) return false;
        Pizza pizza = (Pizza) o;
        return Float.compare (pizza.cost, cost) == 0 && calzone == pizza.calzone && Objects.equals (name, pizza.name) && Objects.equals (ingredients, pizza.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash (name, cost, calzone, ingredients);
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
       if (ingredients.size ()<7) {this.ingredients.add (ingredient);
        this.cost += ingredient.cost;}
       else {
           System.out.println ("  Ingredients are Full !!! \n");}
    }

    public float getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}
