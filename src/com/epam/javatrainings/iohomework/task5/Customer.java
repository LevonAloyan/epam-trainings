package com.epam.javatrainings.iohomework.task5;

import java.io.Serializable;

public class Customer implements Serializable {

    private String name;
    private transient String phone;
    private int score;
    private String cardNumber;

    public Customer(String name, String phone, int score,String cardNumber) {
        this.name = name;
        this.phone = phone;
        this.score = score;
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return name + "," +  phone + "," + score + "," + cardNumber ;
    }

}
