package com.epam.javatrainings.classdecomposition.ingredient;

import java.math.BigDecimal;

public class Ingredient {
    private final String name;
    private final BigDecimal price;

    Ingredient(String name, double price) {
        this.name = name;
        this.price = new BigDecimal(price);
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", price=" + price.doubleValue() +
                '}';
    }
}
