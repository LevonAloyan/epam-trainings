package com.epam.javatrainings.classdecomposition;

import java.util.Locale;
import java.util.Set;

public class Pizza {

    private String defaultName;
    private String name;
    private String type;
    private Set<String> ingredientList;
    private int pizzaQuantity;


    public int getPizzaQuantity() {
        return pizzaQuantity;
    }

    public String getName() {
        return name;
    }

    public void setPizzaQuantity(int pizzaQuantity) {
        this.pizzaQuantity = pizzaQuantity;
    }

    public void setName(String name) {
        boolean isValidName = isValidName(name);
        if (isValidName) {
            this.name = name;
        } else {
            this.name = defaultName;
        }

    }

    /**
     * name must contain at least 4 and no more than 20 Latin characters
     *
     * @param name
     * @return
     */
    private boolean isValidName(String name) {
        boolean validName = false;
        if (name != null && name.length() >= 4 && name.length() <= 20) {
            validName = isLatin(name);
        }

        return validName;
    }

    /**
     * name must contain only Latin characters
     *
     * @param name
     * @return
     */
    private boolean isLatin(String name) {
        boolean validName = true;
        char[] nameArray = name.toLowerCase(Locale.ROOT).toCharArray();
        for (char ch : nameArray) {
            if (ch < 97 || ch > 122) {
                validName = false;
                break;
            }
        }
        return validName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIngredientList(Set<String> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "defaultName='" + defaultName + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", ingredientList=" + ingredientList +
                ", pizzaQuantity=" + pizzaQuantity +
                '}';
    }

}
