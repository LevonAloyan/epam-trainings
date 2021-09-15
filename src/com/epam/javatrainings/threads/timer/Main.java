package com.epam.javatrainings.threads.timer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter minutes: ");
        int minute = input.nextInt();
        System.out.print("Enter seconds: ");
        int second = input.nextInt();
        Thread timer = new Thread(new Timer(minute, second));
        timer.start();
    }
}
