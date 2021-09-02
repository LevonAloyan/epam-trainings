package com.epam.javatrainings.classdecomposition.palmetto;

import com.epam.javatrainings.classdecomposition.palmetto.enums.Ingredient;
import com.epam.javatrainings.classdecomposition.palmetto.enums.Type;

import java.util.List;
import java.util.Set;

public class Pizza {
    private List<Customer> customerList;
    private List<Order> orderList;
    private String name;
    private int rate;
    private Set<Ingredient> ingredient;
    private Type type;
    private int quantity;

    public Pizza(List<Customer> customerList, List<Order> orderList, String name, int rate, int quantity) {
        this.customerList = customerList;
        this.orderList = orderList;
        if (name.length() <= 4 || name.length() > 20) {
            this.name = Customer.getName() +  "_" + Order.getOrderNumber();
        } else {
            this.name = name;
        }
        this.rate = rate;
        this.quantity = quantity;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Set<Ingredient> getIngredient() {
        return ingredient;
    }

    public void setIngredient(Set<Ingredient> ingredient) {
        this.ingredient = ingredient;
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

    public void checkNameLength() {
            this.name = name;
    }

    public void addIngredient() {

    }

    @Override
    public String toString() {
        return "Pizza{" +
                "customerList=" + customerList +
                ", orderList=" + orderList +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", quantity=" + quantity +
                '}';
    }
}
