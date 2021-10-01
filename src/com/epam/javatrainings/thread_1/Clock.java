package com.epam.javatrainings.thread_1;

import java.util.Scanner;

public class Clock {
    Scanner scanner = new Scanner(System.in);

    private void validateTime() throws IllegalClockException, InterruptedException {

        System.out.print("Enter minute: ");
        int minute = scanner.nextInt();
        System.out.print("Enter second: ");
        int second = scanner.nextInt();

        if (minute < 0 | minute > 60) {
            throw new IllegalClockException("Minute must be in (0-60) range");
        }

        if (second < 0 | second > 60) {
            throw new IllegalClockException("Second must be in (0-60) range");
        }
        for (int i = minute; i >= 0; ) {
            for (int j = second; j >= 0; ) {

                if (j < 10) {
                    System.out.println(i + ":0" + j);
                } else {
                    System.out.println(i + ":" + j);
                }
                j--;

                Thread.sleep(1000);
            }
            i--;
            second = 59;
        }
    }

    Thread myThread = new Thread(() -> {
        try {
            validateTime();
        } catch (IllegalClockException | InterruptedException e) {
            e.printStackTrace();
        }
    });

    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.myThread.start();
    }
}
