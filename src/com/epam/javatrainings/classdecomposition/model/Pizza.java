package com.epam.javatrainings.classdecomposition.model;

import com.epam.javatrainings.classdecomposition.util.PizzaUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hayk on 31.08.2021.
 */
public class Pizza {

    private final double basePrice = 1;
    private double price;
    private int quantity;
    private int orderNumber;
    private String name;
    private List<Ingredient> ingredients;
    private PizzaType type;

    public Pizza(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
        this.type = PizzaType.REGULAR;
    }

    public Pizza(double price, int quantity, int orderNumber, String name, PizzaType type) {
        this.price = price;
        this.quantity = quantity;
        this.orderNumber = orderNumber;
        this.name = name;
        this.ingredients = new ArrayList<>();
        this.type = type;
    }

    public Pizza(Pizza pizza, int quantity) {
        this.price = pizza.price;
        this.ingredients = pizza.ingredients;
        this.name = pizza.name;
        this.ingredients = pizza.ingredients;
        this.type = pizza.type;
        this.quantity = quantity;
    }

    public Pizza(String name, PizzaType type) {
        this(0, 0, 0, name, type);
    }

    public Pizza(String name) {
        this(0, 0, 0, name, null);
    }

    public Pizza() {
        this(0, 0, 0, null, null);
    }

    public void addIngredient(Ingredient ingredient) {
        if (ingredients.size() == 8) {
            System.out.println("You cant add ingredient,pizza alredy full");
        } else if (ingredients.contains(ingredient)) {
            System.out.println("This ingredient exist");
        } else {
            ingredients.add(ingredient);
        }
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getPrice() {
        return price;
    }

    public void calculatePrice() {
        double temp = 0;
        for (Ingredient ingredient : ingredients) {
            temp += ingredient.getPrice();
        }
        this.price = this.basePrice + temp + type.getPriceOfType();
    }

    public void printContent(int id) {
        String result = "[ " + orderNumber + ", " + id + ", " + name + ", " + quantity + " ]";
        System.out.println(result);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public PizzaType getType() {
        return type;
    }

    public void setType(PizzaType type) {
        this.type = type;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
}
