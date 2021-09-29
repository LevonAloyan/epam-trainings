package com.epam.javatrainings.iohomework.task2;

import java.io.Serializable;

public class Customer{

    private String name;
    private String phone;
    private int score;

    public Customer(String name, String phone, int score) {
        this.name = name;
        this.phone = phone;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + "," +  phone + "," + score;
    }

}
