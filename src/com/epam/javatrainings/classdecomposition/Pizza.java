package com.epam.javatrainings.classdecomposition;

import java.util.HashMap;
import java.util.List;

import static java.lang.System.exit;
import static java.lang.System.in;

public class Pizza {

    String name;
    HashMap<String, Double> ingredientPrice;
    double cost;
    List <String> ingredients;
    String type;


    Pizza() {
        ingredientPrice = new HashMap<>();
        ingredientPrice.put("Tomato paste", 1.0);
        ingredientPrice.put("Cheese", 1.0);
        ingredientPrice.put("Salami", 1.5);
        ingredientPrice.put("Bacon", 1.2);
        ingredientPrice.put("Garlic", 0.3);
        ingredientPrice.put("Corn", 0.7);
        ingredientPrice.put("Pepperoni", 0.6);
        ingredientPrice.put("Olives", 0.5);
    }

    public Pizza(String name, String type, List<String> ingredients){
        this();
        this.ingredients = ingredients;
        this.name = name;
        this.setType(type);

    }

    public void setType(String type){
        if (type != "REGULAR" && type != "CALZONE"){
            System.out.println("Wrong type - invalid order");
            exit(1);
        }
        this.type = type;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setIngredients(Pizza pizza, List<String> ingredient){
        pizza.ingredients.addAll(ingredient);

    }

    public List<String> getIngredients(){
        return ingredients;
    }

    public void addIngredients(List<String> ingredients){
        for (String ingredient : ingredients) {
            if (this.getIngredients().contains(ingredient)) {
                System.out.println("Make sure the ingredients are not duplicated");
                return;
            }
        }
        this.ingredients.addAll(ingredients);
    }

    public String getType(){
        return type;
    }

    public double getCost(){
        if(type == "REGULAR")
            cost = 1;
        if(type == "CALZONE")
            cost = 1.5;
          for (String ingredient : ingredients) cost += ingredientPrice.get(ingredient);
        return cost;
    }

    public String getBase(){
        if(type == "REGULAR")
            return "(REGULAR) 1.50 ";
        if(type == "CALZONE")
            return "(CALZONE) 1.00 ";
        return null;
    }

}
