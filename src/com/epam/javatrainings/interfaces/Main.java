package com.epam.javatrainings.interfaces;

public class Main {

    public static void main(String[] args) {
       Runnable r =  new Runnable() {
            @Override
            public void run() {
                System.out.println(this.getClass().getName());
            }
        };

//        System.out.println(this.getClass().getName());
//        Runnable r1 = new MyThread();

    }

}
