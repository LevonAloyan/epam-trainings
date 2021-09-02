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
    this.name = customer.getName() + '_' + count;
}
}

public String getName(){
    return name;
}


public void setType(Type t){
    this.type = t;
}

public Type getType(){
  return  this.type;
}


public void addIngredient (Ingredient ingredient) {
    if (ingredients.size() == 8){
        System.out.println("You've already used all available ingredients.");
        return;
    }

    if (ingredients.contains(ingredient)) {
        System.out.println("You've already added that ingredient. Please check the order again");
    } else {
        ingredients.add(ingredient);
    }
}
public void setQuantity(int q) {
    if (q > 12) {
        System.out.println("Not enough");
    } else {
        this.quantity = q;
    }
}

    public int getQuantity(){
        return this.quantity;
    }

public double calculateTotal(){
    double total = 0;
    for (Ingredient i : ingredients){
        total += i.getPrice();
    }
    if (this.type == Type.Calzone){
        total += 1.5;
    }
    else {
        total += 1;
    }
    return quantity * total;
}

    public double calculatePrice(){
        double total = 0;
        for (Ingredient i : ingredients){
            total += i.getPrice();
        }
        if (this.type == Type.Calzone){
            total += 1.5;
        }
        else {
            total += 1;
        }
        return  total;
    }

public void displayAttributes(){
        System.out.println("[" + this.orderId + " : " + this.customer.getId() + " : "+ this.name + " : " + this.quantity+ "]");
    }

    public  List<Ingredient> getIngredients(){
    return this.ingredients;
    }


}
