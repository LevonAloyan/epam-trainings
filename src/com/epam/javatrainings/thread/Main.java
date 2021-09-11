package com.epam.javatrainings.thread;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("How much time (In Minutes) ?");
    int timet= scan.nextInt() * 60; // Convert to seconds
    int sec=scan.nextInt();
    long delay = timet * 100;

    do
    {
      int minutes = timet / 60;
      int seconds = timet % 60;
      System.out.println(minutes +" minute(s), " + seconds + " second(s)");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      timet = timet - 1;
      delay = delay - 100;

    }
    while (delay != 0);
    System.out.println("Time's Up!");
   }
}
