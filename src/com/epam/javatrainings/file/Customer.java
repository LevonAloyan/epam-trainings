package com.epam.javatrainings.file;

import java.io.Serializable;

public class Customer implements Serializable {
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
        return "Customer{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                ", Score=" + score +
                '}';
    }
}
