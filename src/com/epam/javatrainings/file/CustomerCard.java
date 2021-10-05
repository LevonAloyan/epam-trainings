package com.epam.javatrainings.file;

import java.io.Serializable;

public class CustomerCard implements Serializable {
    private String name;
    private String phone;
    private int score;
    private String cardNumber;

    public CustomerCard(String name, String phone, int score, String cardNumber) {
        this.name = name;
        this.phone = phone;
        this.score = score;
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        return "CustomerCard{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", score=" + score +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
