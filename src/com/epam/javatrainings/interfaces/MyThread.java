package com.epam.javatrainings.interfaces;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(this.isAlive());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        while (myThread.isAlive()){
            myThread.interrupt();
            System.out.println(myThread.getState().name());
            System.out.println(myThread.isAlive());
            System.out.println("isAlive");
        }


    }
}

