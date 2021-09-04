package com.epam.javatrainings.classdecomposition.model;

import com.epam.javatrainings.classdecomposition.model.enums.PizzaType;
import com.epam.javatrainings.classdecomposition.model.service.PizzaService;

import java.util.List;
import java.util.Scanner;

public class Pizza {

    private String name;
    private PizzaType pizzaType;
    private int quantity;
    private List<Ingredient> ingredientList;
    private double price;


   /* public Pizza() {
    }
    */


    public Pizza(String name, PizzaType pizzaType, int quantity, List<Ingredient> ingredientList) {
        this.name = name;
        this.pizzaType = pizzaType;
        this.quantity = quantity;

        for (Ingredient i : ingredientList) {
            price += i.getPrice();
        }
        this.price = price;
        this.ingredientList = PizzaService.setIngredientList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }

    public int getQuantity() {
        return quantity;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", pizzaType=" + pizzaType +
                ", quantity=" + quantity +
                ", ingredientList=" + ingredientList +
                ", price=" + price +
                '}';
    }
}
