package com.epam.javatrainings.multiThread;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minute = scanner.nextInt();
        int second = scanner.nextInt();
        if(Validation.isValid(minute,second)) {
            MyTimer myTimer = new MyTimer(minute, second);
            myTimer.run();
        }
    }
}
