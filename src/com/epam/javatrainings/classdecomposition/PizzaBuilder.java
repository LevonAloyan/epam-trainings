package com.epam.javatrainings.classdecomposition;

import java.util.Set;

public class PizzaBuilder {

    private String defaultName;
    private String name;
    private String type;
    private Set<String> ingredientList;
    private int pizzaQuantity;

    Pizza pizza = new Pizza();

    public PizzaBuilder defaultName(String defaultName){
        pizza.setDefaultName(defaultName);
        return this;
    }

    public PizzaBuilder name(String name){
        pizza.setName(name);
        return this;
    }

    public PizzaBuilder type(String type){
        pizza.setType(type);
        return this;
    }

    public PizzaBuilder ingredientList(Set<String> ingredientList){
        pizza.setIngredientList(ingredientList);
        return this;
    }

    public PizzaBuilder pizzaQuantity(int pizzaQuantity){
        pizza.setPizzaQuantity(pizzaQuantity);
        return this;
    }

    public Pizza build(){
        return pizza;
    }

}
