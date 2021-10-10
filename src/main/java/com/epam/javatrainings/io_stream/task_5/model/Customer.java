package com.epam.javatrainings.io_stream.task_5.model;

import java.io.Serializable;

public class Customer implements Serializable {
    private String name;
    private String phone;
    private int score;
    private String cardNumber;

    public Customer(String name, String phone, int score, String cardNumber) {
        this.name = name;
        this.phone = phone;
        this.score = score;
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Customer"
                + "\nname: " + name
                + "\nphone: " + phone
                + "\nscore: " + score
                + "\ncardNumber: " + cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
