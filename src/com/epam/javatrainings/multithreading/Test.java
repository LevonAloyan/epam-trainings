package com.epam.javatrainings.multithreading;

import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        System.out.println("Please enter seconds");
        Scanner scanner = new Scanner(System.in);
        try {
            Thread thread = new Thread(() -> {
                long sec = scanner.nextLong();
                while (sec >= 0) {
                    System.out.println(format(sec--));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });
            thread.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private static String format(long sec) {
        long minute = sec / 60;
        long hour = minute / 60;
        long second = sec % 60;
        minute = minute % 60;
        String h = String.valueOf(hour);
        String m = String.valueOf(minute);
        String s = String.valueOf(second);
        StringBuilder builder = new StringBuilder();
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
