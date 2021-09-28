package com.epam.javatrainings.csv.model;

public class Customer {
    private String name;
    private String tel;
    private int score;

    public Customer(String name, String tel, int score) {
        this.name = name;
        this.tel = tel;
        this.score = score;
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
}
