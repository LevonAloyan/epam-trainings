package com.epam.javatrainings.Threads;

public class Timer implements Runnable {
    public Thread t;
    private int minutes;
    private int seconds;

    public Timer(int m, int s) {
        t = new Thread(this, "Timer");
        minutes = m;
        seconds = s;
        t.start();
    }

    @Override
    public void run() {
        System.out.println("Thread: " + t.getName());

        if(minutes == 0 && seconds == 0) {
            System.out.println(0 + "" + 0 + ":" + 0 + "" + 0);
        } else {
            while(minutes >= 0) {
                while(seconds >= 0) {
                    if(seconds < 10 && minutes < 10) {
                        System.out.println(0 + "" + minutes + ":" + 0 + "" + seconds);
                    } else if(seconds < 10) {
                        System.out.println(minutes + ":" + 0 + "" + seconds);
                    } else if(minutes < 10) {
                        System.out.println(0 + "" + minutes + ":" + seconds);
                    } else {
                        System.out.println(minutes + ":" + seconds);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                    seconds--;
                }
                minutes--;
                seconds = 59;
            }
        }
        System.out.println("TIME FINISHED");
    }
}
