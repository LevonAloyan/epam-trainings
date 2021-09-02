package com.epam.javatrainings.classdecomposition.ingredient;

import com.epam.javatrainings.classdecomposition.taskreader.TaskReader;

import java.util.*;

public final class AvailableIngredientList {

    private static final String path = "./src/com/epam/javatrainings/classdecomposition/homework-part-1.txt";
    private static final int startRowIndex = 5;
    private static final int endRowIndex = 13;
    private static AvailableIngredientList instance;
    private final List<Ingredient> availableIngredients;
    private static int availableIngredientsCount;

    private AvailableIngredientList() {
        availableIngredients = prepareIngredientList();
        availableIngredientsCount = availableIngredients.size();
    }

    public static AvailableIngredientList getInstance() {
        if (instance == null) {
            instance = new AvailableIngredientList();
        }
        return instance;
    }

    public int getAvailableIngredientsCount() {
        return availableIngredientsCount;
    }

    public boolean isIngredientAvailable(Ingredient i) {
        return availableIngredients.contains(i);
    }

    private List<Ingredient> prepareIngredientList() {
        List<String> task = readTask();
        List<String> ingredients = fetchIngredientsFromTask(task);
        return createIngredientList(ingredients);
    }

    private List<String> readTask() {
        TaskReader taskReader = new TaskReader(path);
        return taskReader.getTaskLines();
    }

    private List<String> fetchIngredientsFromTask(List<String> lines) {
        List<String> list = new ArrayList<>();
        lines.stream()
                .skip(startRowIndex)
                .limit(endRowIndex - startRowIndex)
                .forEach(s -> list.add(s
                        .replaceAll("\\s+", " ")
                        .trim())
                );
        return list;
    }

    private List<Ingredient> createIngredientList(List<String> strings) {
        List<Ingredient> ingredientList = new ArrayList<>();
        String cleanLine, name, price, currency;
        for (String s : strings) {
            currency = s.substring(s.length() - 1);
            cleanLine = s
                    .replaceAll("\\s+", " ")
                    .replace(currency, "")
                    .trim();
            int spaceIndex = cleanLine.lastIndexOf(" ");
            name = cleanLine.substring(0, spaceIndex);
            price = cleanLine.substring(spaceIndex);

            ingredientList.add(new Ingredient(name, Double.parseDouble(price), currency));
        }
        return ingredientList;
    }

    public Ingredient findIngredientByName(String name) {

        for (Ingredient ingredient : AvailableIngredientList.getInstance().availableIngredients) {
            if (ingredient.getName().toLowerCase().equals(name)) {
                return ingredient;
            }
        }
        return null;
    }


}
