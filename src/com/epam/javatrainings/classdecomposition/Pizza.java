package com.epam.javatrainings.classdecomposition;

//type, ingredients list, name
public class Pizza {

    private static final String[] pizzaNames = {
            "Margarita",
            "Pepperoni",
            "Romana",
            "Calzone 1",
            "Calzone 2",
            "Calzone 3",
    };

    enum PizzaType {
        REGULAR(1.0),
        CALZONE(1.5);

        private final double basePrice;

        PizzaType(double p) {
            basePrice = p;
        }

        public double getBasePrice() {
            return basePrice;
        }
    }

    enum Ingredients {
        TOMATO_PASTE(1.0),
        CHEESE(1.0),
        SALAMI(1.5),
        BACON(1.2),
        GARLIC(0.3),
        CORN(0.7),
        PEPPERONI(0.6),
        OLIVES(0.5);

        private double IngredientsPrice;

        Ingredients() {
        }

        Ingredients(double p) {
            IngredientsPrice = p;
        }

        public static void addIngredients(String ingredientName) {
            int ingredientCount = 0;
            for (Ingredients ingredients : Ingredients.values()) {
                if (Ingredients.valueOf(ingredientName).equals(ingredients)) {
                    System.out.print(ingredients + " ");
                    ingredientCount++;
                    System.out.println(ingredientCount);
                    return;
                } else {
                    System.out.println("We don't have this ingredient");
                }
            }
        }

        public double getIngredientsPrice() {
            return IngredientsPrice;
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
            System.out.println("Special for you: " + Customer.getCustomerName());

        } else {
            System.out.println("Wrong name: " + Customer.getCustomerName());
        }
    }

    public void choosePizzaName(String pizzaName) {
        validatePizzaName(pizzaName);
    }

    private String[] getPizzaNames() {
        return pizzaNames;
    }
}
