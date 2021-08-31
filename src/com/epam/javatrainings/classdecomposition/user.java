package com.epam.javatrainings.classdecomposition;

public class user {
    public static void main(String[] args) {
       PalmettoPizzeriaCashDesk desk=new PalmettoPizzeriaCashDesk();
       desk.addOrder(Integer.toString(7717));
       desk.getOrder(0).choosePizza();
       desk.getOrder(0).printCheck();
        desk.addOrder(Integer.toString(4372));
        desk.getOrder(1).choosePizza();
        desk.getOrder(1).printCheck();
    }
}
