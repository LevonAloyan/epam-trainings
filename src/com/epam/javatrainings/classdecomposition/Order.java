package com.epam.javatrainings.classdecomposition;

import java.sql.Time;

public class Order {
    private int time;
    private int ordernumber;
    private String name;
    private int count;

    public Order(int time, int ordernumber, String name, int count) {
        this.time = time;
        this.ordernumber = ordernumber;
        this.name = name;
        this.count = count;
    }

    public Order() {

    }

    public int getTime() {
        return time;
    }

    public int getOrdernumber(int i) {
        return ordernumber;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setOrdernumber(int ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Order{" +
                "time=" + time +
                ", ordernumber=" + ordernumber +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}