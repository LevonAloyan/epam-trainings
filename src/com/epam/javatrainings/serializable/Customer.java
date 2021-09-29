package com.epam.javatrainings.serializable;

import java.io.Serializable;

public class Customer implements Serializable {

    private String name;
    private transient String tel;
    private int score;
    private String cardNumber;

    public Customer(String name, String tel, int score, String cardNumber) {
        this.name = name;
        this.tel = tel;
        this.score = score;
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", score=" + score +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
