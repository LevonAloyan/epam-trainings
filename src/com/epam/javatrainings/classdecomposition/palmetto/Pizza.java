package com.epam.javatrainings.classdecomposition.palmetto;

import com.epam.javatrainings.classdecomposition.palmetto.enums.Ingredient;
import com.epam.javatrainings.classdecomposition.palmetto.enums.Type;

import java.util.List;
import java.util.Set;

public class Pizza {
    private List<Customer> customerList;
    int orderNumber;
    private String name;
    private double rate;
    private Set<Ingredient> ingredient;
    private Type type;
    private int quantity;

    public Pizza(List<Customer> customerList, int orderNumber, String name, Type type, Set<Ingredient> ingredient) {
        this.customerList = customerList;
        this.orderNumber = orderNumber;
        checkNameLength(name);
        this.customerList = customerList;
        this.type = type;
        //I'm checking size and then assign it(this.ingredient = ingredient)
        checkIngredientSize(ingredient);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        checkNameLength(name);
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Set<Ingredient> getIngredient() {
        return ingredient;
    }

    public void setIngredient(Set<Ingredient> ingredient) {
        checkIngredientSize(ingredient);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //checking name length to the range
    private void checkNameLength(String name) {
        if (name.length() <= 4 || name.length() > 20) {
            this.name = Customer.getName() + "_" + Order.getOrderNumber();
        } else {
            this.name = name;
        }
    }

    //for check ingredients size
    private void checkIngredientSize(Set<Ingredient> ingredient) {
        if (ingredient.size() == 7) {
            System.out.println("Pizza already full...");
        } else {
            this.ingredient = ingredient;
        }
    }

    //for calculate pizza rate
    public void calculatePrice(Set<Ingredient> ingredient, Type type, int quantity) {
        double rate = 0;
        for (Ingredient ing : ingredient) {
            rate += ing.getRate();
        }
        rate = quantity * (type.getRate() + rate);
        this.rate = rate;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "customerList=" + customerList +
                ", orderNumber=" + orderNumber +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", ingredient=" + ingredient +
                ", rate=$" + rate +
                ", quantity=" + quantity +
                '}';
    }
}
