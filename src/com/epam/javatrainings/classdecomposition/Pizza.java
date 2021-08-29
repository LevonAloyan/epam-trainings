package com.epam.javatrainings.classdecomposition;

import java.util.ArrayList;
import java.util.Iterator;

public class Pizza {

    public static ArrayList<Ingredient> allAvailableIngredients;
    static {
        allAvailableIngredients = new ArrayList<>();
        allAvailableIngredients.add(new Ingredient("Tomato paste", 1));
        allAvailableIngredients.add(new Ingredient("Cheese", 1));
        allAvailableIngredients.add(new Ingredient("Salami", 1.5));
        allAvailableIngredients.add(new Ingredient("Bacon", 1.2));
        allAvailableIngredients.add(new Ingredient("Garlic", 0.3));
        allAvailableIngredients.add(new Ingredient("Corn", 0.7));
        allAvailableIngredients.add(new Ingredient("Pepperoni", 0.6));
        allAvailableIngredients.add(new Ingredient("Olives", 0.5));
    }

    enum Type {
        REGULAR,
        CALZONE
    }
    private Order order;
    private String name;
    private double price;
    private ArrayList<Ingredient> ingredients;
    private int quantity;
    private Type type;

    public Pizza() {
        this.name = null;
        this.quantity = 0;
        this.type = null;
        this.ingredients = null;
        this.price = 0.0;
        this.order = null;
    }

    public Pizza(String name, int quantity, Type type) {
        setName(name);
        setQuantity(quantity);
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity <= 10) {
            this.quantity = quantity;
        } else {
            this.quantity = 10;     // sets the maximal amount of pizzas
        }
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    //Some utility methods
    public double calculatePrice(ArrayList<Ingredient> ingrs) {  //for one specific pizza with given ingredients
        Iterator<Ingredient> iter = ingrs.iterator();
        double price = 0.0;
        while(iter.hasNext()) {
            Ingredient ingredient = iter.next();
            price += ingredient.getPrice();
        }
        price += 1.0;             //adds  $1.0 for base
        if(type == Type.CALZONE) {
            price += 0.5;         //adds extra $0.5 for CALZONE type
        }

        this.price = price;        //sets the price property for each Pizza object

        return price;
    }

    public static void showAllAvailableIngredients() {
        Iterator<Ingredient> iter = allAvailableIngredients.iterator();
        int index = 0;
        System.out.println("Available Ingredients");
        while(iter.hasNext()) {
            Ingredient ingredient = iter.next();
            System.out.println(index + ". " + ingredient.getName() + " - $" + ingredient.getPrice());
            index++;
        }
        System.out.println();
        System.out.println("1. Regular pizza base - " + "$1.0");
        System.out.println("2. Calzone pizza base - " + "$1.5");
    }

    public void displayPizzaAttributes() {
        System.out.println("[" + order.getOrderNumber()
                       + " : " + order.getCustomerNumber()
                       + " : " + name
                       + " : " + quantity
                       + "]");
    }
}
