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
        Timer t = new Timer(Integer.valueOf(splittedInput[0]), Integer.valueOf(splittedInput[1]));
        t.getThread().start();

        try {
            t.getThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("Main Thread is finished");
    }

}
