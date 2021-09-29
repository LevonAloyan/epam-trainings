package com.epam.javatrainings.homework_7.Task_4_5;

import java.io.Serializable;

public class Customer implements Serializable {
    private final String name;
    private final transient String  phoneNumber;
    private String cardNumber;
    private final int score;

    Customer(String name, String phoneNumber, String cardNumber,int score){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.cardNumber = cardNumber;
        this.score = score;
    }

    public String getName () {
        return  name;
    }

    public String getPhoneNumber () {
        return  phoneNumber;
    }

    public int getScore () {
        return  score;
    }

    public String getCardNumber(){return cardNumber;}

    public void setCardNumber(String cardNumber){this.cardNumber = cardNumber;}

    @Override
    public String toString(){
        return this.name + " :    " + this.phoneNumber + " :    "
                + this.cardNumber + " :   " + this.score;
    }
}
