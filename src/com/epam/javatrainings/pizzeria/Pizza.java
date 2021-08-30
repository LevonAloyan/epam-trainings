package com.epam.javatrainings.pizzeria;
import java.util.ArrayList;
import java.util.List;

enum Type {
    Regular,
    Calzone
}

public class Pizza {

private static int count = 0;
private int orderId;
private Customer customer;
private String name;
private int quantity;
private List<Ingredient> ingredients;
private  Type type;

public Pizza(String name, Customer customer, int orderId) {
count ++;
this.ingredients = new ArrayList<Ingredient>();
this.orderId = orderId;
this.customer = customer;
int l = name.length();

if(l>= 4 && l <= 20){
    this.name = name;
}

else {
    this.name = customer.name + '_' + count;
}
}

public String getName(){
    return name;
}

public void setType(Type t){
    this.type = t;
}

public void addIngredient (Ingredient ingredient){
    ingredients.add(ingredient);
}

public void setQuantity(int q) {
    if (q > 10) {
        System.out.println("Not enough");
    } else {
        this.quantity = q;
    }
}
public double calculateTotal(){
    double total = 0;
    for (Ingredient i : ingredients){
        total += i.price;
    }
    if (this.type == Type.Calzone){
        total += 1.5;
    }
    else {
        total += 1;
    }
    return quantity * total;
}
    public void displayAttributes(){
        System.out.println("[" + this.orderId + " : " + this.customer.id + " : "+ this.name + " : " + this.quantity+ "]");
    }

}
