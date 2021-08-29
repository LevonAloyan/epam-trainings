package com.epam.javatrainings.classdecomposition;

import java.util.HashMap;
import java.util.List;

import static java.lang.System.exit;

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
        this.name = name;
        this.setType(type);
        this.setIngredients(ingredients);

    }

    public void setType(String type){
        if (type != "REGULAR" && type != "CALZONE"){
            System.out.println("Wrong type - invalid order");
            exit(1);
        }
        this.type = type;
    }

    public void setIngredients(List<String> ingredients){
        for (String ingredient : ingredients)
            if (ingredientPrice.containsKey(ingredient)){
                System.out.println("Wrong ingredients - invalid order");
                exit(1);
            }
    }

    public List<String> getIngredients(){
        return ingredients;
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

}
