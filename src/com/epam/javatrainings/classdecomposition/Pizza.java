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
        this.ingredients = new ArrayList<>();
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

    /*
       adds an ingredient to the ingredient list
    */
    public void addIngredient(Ingredient newIngredient) {
        if(isFull()) {
            System.out.println("Your pizza is already full");
            System.exit(0);
        } else {
            if(this.getIngredients().contains(newIngredient)) {
                System.out.println("Duplicate ingredient! Check the order again.");
                System.exit(0);
            } else  {
                ingredients.add(newIngredient);
            }
        }
    }

    /*
        checks if a pizza's list of ingredients is full
    */
    private boolean isFull() {
        if(getIngredients().size() == allAvailableIngredients.size()) {
           return  true;
        }
        return false;
    }

    /*
        calculates the price for one specific pizza
    */
    public double calculatePrice() {
        double price = 0.0;
        for(Ingredient i : getIngredients()) {
            price += i.getPrice();
        }

        price += 1.0;             //adds  $1.0 for base
        if(type == Type.CALZONE) {
            price += 0.5;         //adds extra $0.5 for CALZONE type
        }

        this.price = price;        //sets the price property for each Pizza object

        return price;
    }

    /*
        prints the list of all available ingredients
    */
    public static void showAllAvailableIngredients() {
        int index = 0;
        System.out.println("-----------------------------");
        System.out.println("Available Ingredients");
        for(Ingredient i : allAvailableIngredients) {
            System.out.println(index + ". " + i.getName() + " - $" + i.getPrice());
            index++;
        }
        System.out.println();
        System.out.println("1. Regular pizza base - " + "$1.0");
        System.out.println("2. Calzone pizza base - " + "$1.5");

        System.out.println("-----------------------------");
    }

    /*
       prints orderNumber, customerNumber, name and quantity of pizza
    */
    public void displayPizzaAttributes() {
        System.out.println("[" + order.getOrderNumber()
                       + " : " + order.getCustomerNumber()
                       + " : " + name
                       + " : " + quantity
                       + "]");
    }
}
