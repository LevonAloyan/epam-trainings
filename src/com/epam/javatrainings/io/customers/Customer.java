package com.epam.javatrainings.io.customers;

public class Customer implements Comparable<Customer> {
    private String name;
    private String phone;
    private int score;

    public Customer(String name, String phone, int score) {
        this.name = name;
        this.phone = phone;
        this.score = score;
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

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Customer o) {
        return Integer.valueOf(score).compareTo(o.getScore());
    }
}
