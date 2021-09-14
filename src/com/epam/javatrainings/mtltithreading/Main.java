package com.epam.javatrainings.mtltithreading;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input minute");
        int minute = scanner.nextInt();
        System.out.println("Please input second");
        int second = scanner.nextInt();

        Timer timer = new Timer(minute, second);
        timer.startCount();
    }

}
