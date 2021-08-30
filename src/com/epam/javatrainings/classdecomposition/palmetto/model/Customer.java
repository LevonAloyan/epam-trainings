package com.epam.javatrainings.classdecomposition.palmetto.model;

import java.util.ArrayList;

public class Customer {
    private int id;
    private String name;
    private int wallet;
    private ArrayList<Integer> ordered;

    public Customer(int id, String name, int wallet) {
        this.id = id;
        this.name = name;
        this.wallet = wallet;
        ordered=new ArrayList<>();
    }

    public void orderNo(int ord_id) {
        ordered.add (ord_id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getOrdered() {
        return ordered;
    }


}
