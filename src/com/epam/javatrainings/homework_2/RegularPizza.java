package com.epam.javatrainings.homework_2;
import java.util.List;

public class RegularPizza extends Pizza {

    public static final String type = "regular";

    private String pizzaName;

    private int count;

    private List<Ingredients> ingredients;


    public RegularPizza(List<Ingredients> ingredients, String name, int count) {
        this.ingredients = ingredients;
        this.pizzaName = name;
        this.count = count;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

