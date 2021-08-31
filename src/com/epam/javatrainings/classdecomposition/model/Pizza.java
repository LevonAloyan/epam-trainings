package com.epam.javatrainings.classdecomposition.model;

import com.epam.javatrainings.classdecomposition.util.PizzaUtil;

/**
 * Created by Hayk on 31.08.2021.
 */
public class Pizza {
    private String name;
    private Ingredient[] ingredients = new Ingredient[8];
    private final double basePrice = 1;
    private double price;
    private int quantity;
    private PizzaType type;

    private final int orderNumber;

    public Pizza() {
        orderNumber = PizzaUtil.generateOrderNumber();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient[] ingredients) {
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
