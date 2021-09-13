package com.epam.javatrainings.timer;

import com.sun.xml.internal.ws.encoding.soap.SOAP12Constants;

public class Timer implements Runnable {

    private int min;
    private int sec;
    private int totalSeconds;
    private static volatile boolean stop = false;

    public Timer(int min, int sec) {
        this.min = min;
        this.sec = sec;
        totalSeconds = min * 60 + sec;
    }

    @Override
    public void run() {
        while (totalSeconds > 0 && !stop) {
            if (sec == 0) {
                sec = 60;
                min--;
            }
            if (sec < 11) {
                System.out.println(min + " : 0" + --sec);
            } else {
                System.out.println(min + " : " + --sec);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            totalSeconds--;
        }
        if (stop) {
            System.out.println("Timer is stopped by You");
        } else {
            System.out.println("Its TIME !!!");
            System.out.println("Please press Enter to exit");
        }
    }

    public static void stop() {
        stop = true;
    }
}
