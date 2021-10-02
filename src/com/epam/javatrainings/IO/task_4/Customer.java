package com.epam.javatrainings.IO.task_4;

import java.io.Serializable;

public class Customer implements Serializable {

    private String name;
    private String phone;
    private int score;

    public Customer(String name, String phone, int score){
        this.name = name;
        this.phone = phone;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + " " + phone + " " + score;
    }
}
