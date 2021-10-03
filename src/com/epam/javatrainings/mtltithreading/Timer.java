package com.epam.javatrainings.mtltithreading;

public class Timer extends Thread {

    private int minute;
    private int second;

    public Timer(int minute, int second) {
        this.minute = minute;
        this.second = second;
    }

    public void startCount() {
        Thread minuteThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (minute >= 0) {
                    while (second >= 0) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (second < 10) {
                            System.out.println(minute + " : 0" + second);
                        }
                        else {
                            System.out.println(minute + " : " + second);
                        }
                        second--;
                    }
                    minute--;
                    second = 59;
                }
            }
        });

        minuteThread.start();
    }

}
