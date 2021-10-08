package com.epam.javatrainings.thread;

import com.epam.javatrainings.classdecomposition.validator.Validator;

import java.util.Scanner;

/**
 * Created by Hayk on 13.09.2021.
 */
public class Main {
    private static String inputting(Scanner scanner,String message){
        System.out.print(message);
         return scanner.nextLine();
    }
    public static void main(String[] args) {
        int hours=0;
        int minutes=0;
        int seconds=0;
        Scanner scanner=new Scanner(System.in);

        String temp=inputting(scanner,"Please enter the hours: ");
        if(Validator.isInt(temp)){
            hours=Integer.parseInt(temp);
        }
        temp=inputting(scanner,"Please enter the minutes: ");
        if(Validator.isInt(temp)){
            minutes=Integer.parseInt(temp);
        }
        temp=inputting(scanner,"Please enter the seconds: ");
        if(Validator.isInt(temp)){
            seconds=Integer.parseInt(temp);
        }
        System.out.println("The countdown has begun");

        Thread thread=new Timer(hours,minutes,seconds);
        thread.start();
        scanner.close();
//To test the class CurretTime comment all before

//        Thread thread=new CurrentTime();
//         thread.start();
    }
}
