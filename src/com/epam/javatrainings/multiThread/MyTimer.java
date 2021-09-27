package com.epam.javatrainings.multiThread;

public class MyTimer extends Thread{
    private int minute;
    private int second;

    public MyTimer(int minute, int second) {
        this.minute = minute;
        this.second = second;
    }

    @Override
    public void run() {

        while (minute >= 0) {
            for ( ; second >= 0; second--) {
             print(minute, second);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            minute--;
            second = 60;
        }

    }
    static void print(int minute, int second){
        if(minute < 10){
            if(second < 10){
                System.out.println(0 + "" + minute + " : " + '0' + second);
            }
            else {
                System.out.println(0 + ""  + minute + " : " + second);
            }
        }
        else {
            if (second < 10) {
                System.out.println(minute + " : " + 0 + second);
            }else {
                System.out.println(minute + " : " + second);
            }

        }
    }
}
