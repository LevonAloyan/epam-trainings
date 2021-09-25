package com.epam.javatrainings.timer_thread_task;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please input minute for timer");
                int minute = scanner.nextInt();
                System.out.println("Please input seconds for timer");
                int seconds = scanner.nextInt();
                for (int i = minute; i >= 0; i--) {
                    for (int j = seconds; j >= 0; j--) {
                        try {
                            Thread.sleep(1000);
                            if (i < 10) {
                                System.out.print("0" + i + " : ");
                            } else if (i == 0) {
                                System.out.print("00 : ");
                            } else {
                                System.out.print(i + " : ");
                            }
                            if (j < 10) {
                                System.out.println("0" + j);
                            } else if (j == 0) {
                                System.out.println("00");
                            } else if (j == 60) {
                                j = 59;
                                System.out.println(j);
                            } else {
                                System.out.println(j);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    seconds = 60;
                }
            }
        });
        myThread.start();
    }
}
