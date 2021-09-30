package com.epam.javatrainings.classdecomposition.persistance;

public class Customer{
    private String name;
    private double money = 5.5;

    public Customer(String name, double money) {
        this.setName(name);
        this.setMoney(money);
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 15) {
            this.name = name;
        }
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if (money >= 0) {
            this.money = money;
        }
    }
}
