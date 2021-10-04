package com.epam.javatrainings.classdecomposition.ingredient;

import java.util.Objects;
import java.math.BigDecimal;

public final class Ingredient {
    private final String name;
    private final BigDecimal price;
    private final String currency;

    public Ingredient(String name, BigDecimal price, String currency) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public boolean isAvailable() {
        return AvailableIngredientList.getInstance().isIngredientAvailable(this);
    }


    public String describe() {
        return name
                .concat(" ")
                .concat(price.toString())
                .concat(" ")
                .concat("€");
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
        return Objects.equals(name, that.name) &&
                Objects.equals(price, that.price) &&
                Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, currency);
    }
}
