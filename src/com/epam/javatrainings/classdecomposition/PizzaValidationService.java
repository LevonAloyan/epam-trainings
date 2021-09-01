package com.epam.javatrainings.classdecomposition;

import java.util.Locale;

public class PizzaValidationService {

    private Pizza pizza;

    public PizzaValidationService(Pizza pizza) {
        this.pizza = pizza;
    }

    public boolean pizzaValidation(){
        if (pizza.getType() == null || pizza.getDefaultName() == null) {return false;}

        return true;

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
}
