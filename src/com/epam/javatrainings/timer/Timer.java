package com.epam.javatrainings.timer;

import java.util.Scanner;

public class Timer extends Thread {
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter minute");
        int minutes = scanner.nextInt();
        System.out.println("Please enter second");
        int seconds = scanner.nextInt();
        if(seconds > 60 || seconds < 0){
            System.out.println("0 < Seconds < 60 ");
        }

        for (int i = minutes; i >= 0;  ) {
            for (int j = seconds; j >= 0 ; j--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i+"."+j);

            }
            seconds =59;
            i--;

        }
    }


}
