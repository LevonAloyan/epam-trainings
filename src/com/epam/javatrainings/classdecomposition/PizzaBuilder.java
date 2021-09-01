package com.epam.javatrainings.classdecomposition;

import java.util.Locale;
import java.util.Set;

public class PizzaBuilder {

    private String defaultName;
    private String name;
    private String type;
    private Set<String> ingredientList;
    private int pizzaQuantity;

    private Pizza pizza;

    public PizzaBuilder defaultName(String defaultName) {
        //pizza.setDefaultName(defaultName);
        this.defaultName = defaultName;
        return this;
    }

    public PizzaBuilder name(String name) {
        //pizza.setName(name);
        this.name = name;
        return this;
    }

    public PizzaBuilder type(String type) {
        //pizza.setType(type);
        this.type = type;
        return this;
    }

    public PizzaBuilder ingredientList(Set<String> ingredientList) {
        //pizza.setIngredientList(ingredientList);
        this.ingredientList = ingredientList;
        return this;
    }

    public PizzaBuilder pizzaQuantity(int pizzaQuantity) {
        //pizza.setPizzaQuantity(pizzaQuantity);
        this.pizzaQuantity = pizzaQuantity;
        return this;
    }

    public Pizza build() {
        return pizza;
    }
}
