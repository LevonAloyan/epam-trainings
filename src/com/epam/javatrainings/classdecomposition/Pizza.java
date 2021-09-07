package com.epam.javatrainings.classdecomposition;

import java.util.ArrayList;
import java.util.HashMap;

public class Pizza {
    static private Integer pizzaIdGenerator;
    final static int MAX_INGREDIENTS=5;

    static private HashMap<String, Double> ingredients;//list of ingredients can be extended
    static {
        ingredients=new HashMap<String,Double>();
        ingredients.put("Tomato paste", 1.0);
        ingredients.put("Cheese", 1.0);
        ingredients.put("Salami", 1.5);
        ingredients.put("Bacon", 1.2);
        ingredients.put("Garlic", 0.3);
        ingredients.put("Corn", 0.7);
        ingredients.put("Pepperoni", 0.6);
        ingredients.put("Olives", 0.5);
        pizzaIdGenerator =0;
    }//init ingredients list with costs
    private Integer pizza_id;//pizza id
    private String name;// pizza name;
    private Type type;// pizza type Regular or Cazoline

    public ArrayList<String> getActual_ingredients() {
        return actual_ingredients;
    }

    private ArrayList<String> actual_ingredients;//ingredients that the customer chosen
    private Integer quantity;
    public Pizza()//
    {
        actual_ingredients=new ArrayList<String>();
        pizzaIdGenerator++;
        pizza_id= pizzaIdGenerator;
    }
    public String getName() {
        return name;
    }//get pizza Name

    public void setName(String name,String customer) {
        if(name.length()<4||name.length()>20)
        {
            this.name=customer+"_"+pizza_id;
        }else
            this.name = name;
    }//set pizza name logic

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    public void addIngredient(String i)//add ingredients to pizza
    {
        if(actual_ingredients.size()==MAX_INGREDIENTS){
            System.out.println("No place for ingredients");
            return;
        }
        if(ingredients.containsKey(i))
            actual_ingredients.add(i);
        else
            System.out.println("no such ingredient");
    }
    static public  void showIngredientList()//show ingredients list
    {
        ingredients.entrySet().forEach(item -> {
            System.out.println(item.getKey() + " " + item.getValue()+"$");
        });
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public static HashMap<String, Double> getIngredients() {
        return ingredients;
    }
}
