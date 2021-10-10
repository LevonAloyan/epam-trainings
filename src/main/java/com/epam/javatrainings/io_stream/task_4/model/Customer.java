package com.epam.javatrainings.io_stream.task_4.model;

import java.io.Serializable;

public class Customer implements Serializable {
    private String name;
    private transient String phone;
    private int score;

    public Customer(String name, String phone, int score) {
        this.name = name;
        this.phone = phone;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Customer"
                + "\nname: " + name
                + "\nphone: " + phone
                + "\nscore: " + score;
    }
}
