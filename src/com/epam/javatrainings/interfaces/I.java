package com.epam.javatrainings.interfaces;

@FunctionalInterface
public interface I {

    void print(int a);


    default void print(){
        dosmth();
        System.out.println("print");
    }

    default void print1(){
        dosmth();
        System.out.println("print1");
    }

    private void dosmth(){
        System.out.println("");
    }
}
// is-a extend
// has-a implement