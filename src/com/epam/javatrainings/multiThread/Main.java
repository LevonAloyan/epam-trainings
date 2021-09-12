package com.epam.javatrainings;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final Scanner seconds = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Enter Seconds");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int sec = seconds.nextInt();
                while (sec >= 0) {
                    try {
                        System.out.println(clock(sec));
                        sec--;
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t = new Thread(runnable);
        t.start();
    }

    public static String clock(int sec) {
        int hour = sec / 3600;
        int second = sec % 60;
        int minute = sec / 60 % 60;
        String h = "" + hour;
        String s = "" + second;
        String m = "" + minute;
        if (hour < 10) {
            h = "0" + h;
        }
        if (minute < 10) {
            m = "0" + m;
        }

        if (second < 10) {
            s = "0" + s;
        }
        return h + ":" + m + ":" + s;
    }
}