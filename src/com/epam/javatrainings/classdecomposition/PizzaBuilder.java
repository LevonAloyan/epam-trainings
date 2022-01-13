package com.epam.javatrainings.classdecomposition;

import java.io.Serializable;
import java.util.Set;

public class PizzaBuilder implements Serializable{

    private final Pizza pizza = new Pizza();

    public PizzaBuilder defaultName(String defaultName) {
        pizza.setDefaultName(defaultName);
        return this;
    }

    public PizzaBuilder name(String name) {
        pizza.setName(name);
        return this;
    }

    public PizzaBuilder type(String type) {
        pizza.setType(type);
        return this;
    }

    public PizzaBuilder ingredientList(Set<String> ingredientList) {
        pizza.setIngredientList(ingredientList);
        return this;
    }

    public PizzaBuilder pizzaQuantity(int pizzaQuantity) {
        pizza.setPizzaQuantity(pizzaQuantity);
        return this;
    }

    public Pizza build() {
        return pizza;
    }

    class Pizza implements Serializable{

        private String defaultName;
        private String name;
        private String type;
        private Set<String> ingredientList;
        private int pizzaQuantity;

        private Pizza() {

        }

        public String getType() {
            return type;
        }

        public Set<String> getIngredientList() {
            return ingredientList;
        }

        public int getPizzaQuantity() {return pizzaQuantity; }

        public String getName() {
            return name;
        }

        private void setPizzaQuantity(int pizzaQuantity) {
            this.pizzaQuantity = pizzaQuantity;
        }

        private void setName(String name) {
            boolean isValidName = PizzaValidationService.isValidName(name);
            if (isValidName) {
                this.name = name;
            } else {
                this.name = defaultName;
            }

        }


        private void setType(String type) {
            this.type = type;
        }

        private void setIngredientList(Set<String> ingredientList) {
            this.ingredientList = ingredientList;
        }

        private void setDefaultName(String defaultName) {this.defaultName = defaultName;}






    }
}
