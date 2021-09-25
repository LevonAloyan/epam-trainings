package com.epam.javatrainings.multiThread;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter preferable minute");
        int minute = scanner.nextInt();
        System.out.println("Please enter preferable second");
        int second = scanner.nextInt();
        if(Validation.isValid(minute,second)) {
            MyTimer myTimer = new MyTimer(minute, second);
            myTimer.start();
        }
    }
}
