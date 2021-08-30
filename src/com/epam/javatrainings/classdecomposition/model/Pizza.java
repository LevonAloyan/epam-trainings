package com.epam.javatrainings.classdecomposition.model;

import com.epam.javatrainings.classdecomposition.model.enums.PizzaType;

import java.util.List;

public class Pizza {

    private String name;
    private PizzaType pizzaType;
    private int quantity;
    private List<Ingredient> ingredientList;


    public Pizza(String name, PizzaType pizzaType, int quantity) {
        this.name = name;
        this.pizzaType = pizzaType;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name, int numberOfCustomer) {
        if(name.length() >= 4 && name.length() <= 20) {
            this.name = name;
        }
        else {
            this.name = "customer_name_" + numberOfCustomer;
        }
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }

    public int getQuantity() {
        if(quantity <= 10 && quantity > 0) {
            return quantity;
        }
        else {
            return 0;
        }
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
