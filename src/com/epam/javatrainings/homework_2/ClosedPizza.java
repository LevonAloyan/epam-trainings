package com.epam.javatrainings.homework_2;

import java.util.List;

public class ClosedPizza extends Pizza {

    public static final String type = "Closed Pizza";

    private String name;

    private int count;

    private List<Ingredients> ingredients;

    public ClosedPizza(List<Ingredients> ingredients, String name, int count) {
        this.ingredients = ingredients;
        this.count = count;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

