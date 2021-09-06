package com.epam.javatrainings.classdecomposition.ingredient;

import java.util.List;
import java.util.ArrayList;

public class IngredientListUtil {

    public static List<Ingredient> copyIngredientList(List<Ingredient> ingredientList) {
        List<Ingredient> copy = new ArrayList<>();
        for (Ingredient i : ingredientList) {
            copy.add(new Ingredient(i.getName(), i.getPrice(), i.getCurrency()));
        }
        return copy;
    }
}
