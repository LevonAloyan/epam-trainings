package com.epam.javatrainings.classdecomposition;

public class user {
    public static void main(String[] args) {
        PalmettoPizzeriaCashDesk.Order order=new PalmettoPizzeriaCashDesk.Order("Alisa");
        order.choosePizza();
        order.seeMyPizza();
        System.out.println(order.cost());
    }
}
