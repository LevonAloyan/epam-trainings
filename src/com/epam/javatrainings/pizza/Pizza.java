package com.epam.javatrainings.pizza;

//constructor
//(pizza, ingredient,type)
public class Pizza {
    /*PizzaType pizzaType;
    Ingredients ingredient;
    private String name;*/

    Pizza(String name, PizzaType type, Ingredients ingredient) {

    }

    private static final String[] pizzaNames = {
            "Margarita",
            "Pepperoni",
            "Romana",
            "Calzone 1",
            "Calzone 2",
            "Calzone 3",
    };

    public static void addIngredients(String ingredientName) {
        int ingredientCount = 0;
        for (Ingredients ingredients : Ingredients.values()) {
            if (Ingredients.valueOf(ingredientName).equals(ingredients)) {
                System.out.println(ingredients);
                ingredientCount++;
                System.out.println(ingredientCount);
                return;
            } else {
                System.out.println("We don't have this ingredient");
            }
        }
    }

    private void validatePizzaName(String pizzaName) {
        if (pizzaName.length() > 3 && pizzaName.length() < 21) {
            for (String name : getPizzaNames()) {
                if (name.equals(pizzaName)) {
                    System.out.println("You choose pizza: " + pizzaName);
                    return;
                }
            }
            System.out.println("Special for you: " + Customer.getName());
        } else {
            System.out.println("Wrong name: " + Customer.getName());
        }
    }

    public void choosePizzaName(String pizzaName) {
        validatePizzaName(pizzaName);
    }

    private String[] getPizzaNames() {
        return pizzaNames;
    }
}
