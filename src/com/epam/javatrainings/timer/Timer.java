package com.epam.javatrainings.timer;


import java.util.Scanner;

public class Timer extends Thread {
    long minutes=0;
    long seconds=0;
    @Override
    public void run() {
       getAndValidateMinutes();
       getAndValidateSeconds();
       startTimer();
    }
    private void getAndValidateMinutes(){
        long checkedMinutes =0;
        boolean correctInput=false;
        while(!correctInput){
            try {
                System.out.print("Write minutes: ");
                Scanner getMinutes = new Scanner(System.in);
                checkedMinutes=getMinutes.nextLong();
                if(checkedMinutes<0) {
                    System.out.println("Can't be Negative number! Try again!");
                }else if(checkedMinutes>60){
                    System.out.println("Can't be greater than 60! Try again!");
                }else{
                    minutes=checkedMinutes;
                    correctInput=true;
                }
            } catch(Exception ex) {
                    System.out.println("Wrong format! Try again!");
            }
        }
    }
    private void getAndValidateSeconds(){
        long checkedSeconds =0;
        boolean correctInput=false;
        while(!correctInput){
            try {
                System.out.print("Write seconds: ");
                Scanner getSeconds = new Scanner(System.in);
                checkedSeconds=getSeconds.nextLong();
                if(checkedSeconds<0) {
                    System.out.println("Negative number! Try again!");
                }else if(checkedSeconds>60){
                    System.out.println("Can't be greater than 60! Try again!");
                } else{
                    seconds=checkedSeconds;
                    correctInput=true;
                }
            } catch(Exception ex) {
                System.out.println("Wrong format! Try again!");
            }
        }
    }
    private void startTimer() {
        boolean isWorking = true;
        while(isWorking){
            if(seconds==-1){
                minutes--;
                seconds+=60;
            }
            System.out.println(String.format("%s:%s",String.format("%02d",minutes),String.format("%02d",seconds)));
            if(minutes==0&&seconds==0){
                isWorking=false;
            }else {
                seconds--;
            }
            try {
                Thread.sleep(1000);
            }catch (InterruptedException exc){
                System.out.println("Error!");
            }

        }
    }
}
