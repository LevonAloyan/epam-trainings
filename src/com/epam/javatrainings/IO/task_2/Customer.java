package com.epam.javatrainings.IO.task_2;


public class Customer implements Comparable<Customer> {

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

    @Override
    public int compareTo(Customer o) {
        return Integer.compare(this.score, o.score);
    }
}
