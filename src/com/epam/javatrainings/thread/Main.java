package com.epam.javatrainings.thread;

import java.util.Scanner;
import static java.lang.Thread.sleep;

public class Main {
  public static void main(String[] args) {
    Thread countDown =
        new Thread(
            () -> {
              Scanner scan = new Scanner(System.in);
              System.out.println("How much time (In Minutes) ?");

              int timet = scan.nextInt() * 60; // Convert to seconds
              System.out.println("How much time (In seconds) ?");

              int sec = scan.nextInt();
              timet += sec;
              long delay = timet * 100L;

              do {
                int minutes = timet / 60;
                int seconds = timet % 60;
                System.out.println(minutes + " minute(s), " + seconds + " second(s)");
                try {
                  sleep(1000);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
                timet = timet - 1;
                delay = delay - 100;

              } while (delay != 0);
              System.out.println("Time's Up!");
            });
    countDown.start();
  }
}
