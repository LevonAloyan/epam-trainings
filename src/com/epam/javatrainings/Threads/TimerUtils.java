package com.epam.javatrainings.Threads;

import java.util.Scanner;

public class TimerUtils {

    private static Scanner scanner = new Scanner(System.in);

    public static int setTimer(String measure) {
        boolean check = true;
        int input;
        do {
            System.out.print(measure + ": ");
            input = scanner.nextInt();
            if(input <= 59 && input >= 0) {
                check = false;
            }
        } while(check);
        return input;
    }
}
