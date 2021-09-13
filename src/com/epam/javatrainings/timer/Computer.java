package com.epam.javatrainings.timer;

public class Computer {
    public static void main(String[] args){
        Timer thread=new Timer();
        thread.start();
        try {
            thread.join();
        }catch(InterruptedException ex){

        }
    }
}
