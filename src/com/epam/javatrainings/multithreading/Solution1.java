package com.epam.javatrainings.multithreading;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println("Please enter Hour and Minute #2");
        Scanner scanner = new Scanner(System.in);
        int numHour = scanner.nextInt();
        int numMinutes = scanner.nextInt();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Task #2 is running");
                int tmp1 = numHour;
                int tmp2 = numMinutes;
                boolean stop = false;
                while (!stop) { //if I already initialized as false why do I need to put the "!" sign without this sign it doesn't work and doesn't enter while block
                    tmp2--;
                    if (tmp1 != 0 && tmp2 == 0) {
                        tmp2 = 59;
                        tmp1--;
                    }
                    if (tmp1 == 0 && tmp2 == 0) {
                        stop = true;
                    }
                    System.out.printf("%02d:%02d", tmp1, tmp2);
                    System.out.println();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
    });
        thread2.start();
}
}
