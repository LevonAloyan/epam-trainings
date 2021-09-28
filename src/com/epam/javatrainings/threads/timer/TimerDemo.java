package com.epam.javatrainings.threads.timer;

import java.util.Scanner;

public class TimerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter minute and second in the format \"m:s\"");
        String input = scanner.nextLine();

        while (!TimeFormatValidator.isValid(input)) {
            System.out.println("Invalid time format, please provide time in the following format \"m:s\"");
            input = scanner.nextLine();
        }

        String [] splittedInput = input.split(TimeFormatValidator.timeSeparator);

        System.out.println("Starting countdown ...");
        Timer timer = new Timer(Integer.valueOf(splittedInput[0]), Integer.valueOf(splittedInput[1]));
        Thread timerThread = new Thread(timer);
        timerThread.start();

        try {
            timerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("Main Thread is finished");
    }

}
