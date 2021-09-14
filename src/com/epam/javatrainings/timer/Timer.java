package com.epam.javatrainings.timer;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Timer extends Thread{
    private int minute;
    private int second;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int minute=sc.nextInt();
        int second=sc.nextInt();
        if(minute<0||second>60||second<0)
        {
            System.out.println("Invalid time input");
            return;
        }
        Timer t=new Timer(minute,second);
        t.start();
    }
    Timer(int minute,int second)
    {
        super();
        this.minute=minute;
        this.second=second;
    }

    @Override
    public void run() {
        LocalTime start= LocalTime.now();
        try {
            while (minute+second!=0) {
                System.out.printf("%d : %02d \n",minute,second);
                if(second==0) {
                    minute--;
                    second = 59;
                }else {
                    second--;
                }

                Thread.sleep(1000);
            }
            System.out.println("BoooM!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        float runtime=(LocalTime.now().getSecond()-start.getSecond());
        System.out.println("Actual run time "+runtime);

    }
}
