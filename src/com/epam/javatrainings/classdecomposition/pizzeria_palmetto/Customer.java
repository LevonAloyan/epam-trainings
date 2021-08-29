package com.epam.javatrainings.classdecomposition.pizzeria_palmetto;

public class Customer {
    private final int numberCustomer;
    private String nameCustomer;
    private String namePizza;

    public Customer(String nameCustomer, String namePizza) {
        this.numberCustomer = PlacingAnOrder.GeneratorNumber.initialNumberCustomer++;
        this.nameCustomer = nameCustomer;
        this.namePizza = namePizza;
    }

    public Customer(String nameCustomer) {
        this.numberCustomer = PlacingAnOrder.GeneratorNumber.initialNumberCustomer++;
        this.nameCustomer = nameCustomer;
    }

    public int getNumberCustomer() {
        return numberCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getNamePizza() {
        return namePizza;
    }

    public void setNamePizza(String namePizza) {
        this.namePizza = namePizza;
    }


}
