package com.epam.javatrainings.homework_7.Task2;

public class Customer {
    private final String name;
    private final String phoneNumber;
    private final int score;

    Customer(String name, String phoneNumber, int score){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.score = score;
    }

    public int getScore () {
        return  score;
    }

    @Override
    public String toString(){
        return this.name + " :    " + this.phoneNumber + " :    " + this.score;
    }
}
