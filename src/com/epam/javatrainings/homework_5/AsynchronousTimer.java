package com.epam.javatrainings.homework_5;
import java.util.Scanner;
import java.lang.Thread;
import java.lang.Runnable;

public class AsynchronousTimer {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int minutes  = sc.nextInt();
        int seconds = sc.nextInt();
        /*     if(seconds > 59){
                   minutes += seconds / 60;
                   seconds = seconds % 60;
        }  */

        new Thread(new Runnable() {
            @Override
            public void run() {
              int  tempSeconds = seconds;
              int  tempMinutes = minutes;
                while (tempMinutes >= 0){
                    while (tempSeconds >= 0){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(tempMinutes +  " : " + tempSeconds);
                        tempSeconds--;
                    }
                    tempMinutes --;
                    tempSeconds = 59;
                }

            }
        }
        ).start();
    }
}



