package com.epam.javatrainings.classdecomposition.ingredient;

import java.util.Objects;

public final class Ingredient {
    private final String name;
    private final double price;
    private final String currency;

    public Ingredient(String name, double price, String currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

    public Ingredient(Ingredient ingredient) {
        this.name = ingredient.name;
        this.price = ingredient.price;
        this.currency = ingredient.currency;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public boolean isAvailable() {
        return AvailableIngredientList.getInstance().isIngredientAvailable(this);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Double.compare(that.price, price) == 0 && name.equals(that.name) && currency.equals(that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, currency);
    }

}
