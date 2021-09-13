package com.epam.javatrainings.thread;

import java.time.LocalTime;

/**
 * Created by Hayk on 14.09.2021.
 */
public class CurrentTime extends Thread {
    @Override
    public void run(){
        LocalTime localTime=LocalTime.now();
        System.out.print(localTime);
        while (true){
            try {
                Thread.sleep(300); // Just to give the user a chance to see "hello".
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            localTime=LocalTime.now();
            System.out.printf("\r%s",localTime);
        }
    }
}
