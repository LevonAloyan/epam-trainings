package com.epam.javatrainings.thread;

/**
 * Created by Hayk on 14.09.2021.
 */
public class Timer extends Thread{
    private int minutes;
    private int seconds;
    private int hours;
    public Timer(int hours,int minutes,int seconds){
        this.hours=hours;
        this.minutes=minutes;
        this.seconds=seconds;
        fixingFormat();
    }
    @Override
    public void run(){
        countdown(hours,minutes,seconds);
    }

    private void fixingFormat(){
        if(this.seconds>59){
            this.minutes+=this.seconds/60;
            this.seconds=this.seconds%60;
        }
        if (this.minutes>59){
            this.hours+=this.minutes/60;
            this.minutes=minutes%60;
        }
    }

    private String formatting(int hours,int minutes,int seconds){
        StringBuilder res=new StringBuilder();
        res=appending(res,hours).append(":");
        res=appending(res,minutes).append(":");
        res=appending(res,seconds);
        return res.toString();
    }

    private StringBuilder appending(StringBuilder s,int a){
        return a<10?s.append("0").append(a):s.append(a);
    }
    private void countdown(int hours,int minutes,int seconds){
        System.out.print(formatting(hours,minutes,seconds));
        while (hours!=0||minutes!=0||seconds!=0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (seconds>0){
                --seconds;
            }else if(minutes>0){
                --minutes;
                seconds=59;
            }else if(hours>0){
                --hours;
                minutes=59;
                seconds=59;
            }
            System.out.printf("\r%s",formatting(hours,minutes,seconds));
        }
        System.out.println("BOOOM");
    }
}
