package com.epam.javatrainings.classdecomposition.palmetto.model.Ingredients;

public abstract class Ingredient {
    private static int counter;
    private String name;
    public float cost;

    public Ingredient(String name, float cost){
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

    public String getName() {
        return name;
    }

    public float getCost() {
        return cost;
    }
}
