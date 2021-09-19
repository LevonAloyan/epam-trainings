package com.epam.javatrainings.threads.timer;

import com.epam.javatrainings.threads.timer.exceptions.InvalidMinuteException;
import com.epam.javatrainings.threads.timer.exceptions.InvalidSecondException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter minutes: ");
        int minute = input.nextInt();
        if (minute < 0 || minute >= 59) {
            throw new InvalidMinuteException("Minute have to be range of 0-59");
        }
        System.out.print("Enter seconds: ");
        int second = input.nextInt();
        if (second < 0 || second >= 59) {
            throw new InvalidSecondException("Second have to be range of 0-59");
        }
        Thread timer = new Thread(new Timer(minute, second));
        timer.start();
    }
}
