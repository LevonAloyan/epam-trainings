package com.epam.javatrainings.homework_2;

public abstract class Pizza {

    private String pizzaName;

    public void checkPizzaName(String customerName, int indexNumber) {
        if (pizzaName.length() < 4 || pizzaName.length() > 20) {
            pizzaName = customerName + "_" + pizzaName + "_" + indexNumber;
        }
    }
}

