package com.epam.javatrainings.classdecomposition.palmetto.model;

import com.epam.javatrainings.classdecomposition.palmetto.model.Ingredients.Ingredient;

import java.util.*;


public class Pizza {
    private String name;
    private float cost;
    private boolean calzone;
    private float base;
    private Set<Ingredient> ingredients = new HashSet<Ingredient> ();

    public Pizza(boolean calzone) {
        this.calzone = calzone;
        if (calzone) this.cost= this.base = 1.5F;
        else this.cost= this.base = 1F;
    }

    public Pizza(String name, boolean calzone) {

        this.calzone = calzone;
        this.name = name;
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

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        if (ingredients.size () < 7) {
            if (ingredients.contains (ingredient)) {
                System.out.println (" Ingredient has already added");
            } else {
                this.ingredients.add (ingredient);
                this.cost += ingredient.cost;
            }
        } else {
            System.out.println ("  Ingredients are Full !!! \n");
        }
    }

    public String showIngredients() {
        StringBuilder sb = new StringBuilder ();

        ingredients
                .forEach (each -> sb.append (each.getName ()).append (" ").append (each.getCost ()).append ("$\n"));
        return sb.toString ();
    }

    public float getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
    public int getIngredientsCount() {
        return ingredients.size ();
    }
    public float getBase() {
        return base;
    }
}
