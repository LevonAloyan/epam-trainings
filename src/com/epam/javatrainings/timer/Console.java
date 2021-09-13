package com.epam.javatrainings.timer;

import java.util.Scanner;

public class Console {
    private static int min;
    private static int sec;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("input minutes");
        min = Integer.parseInt(scanner.nextLine());
        System.out.println("input seconds");
        sec = Integer.parseInt(scanner.nextLine());

        Timer timer = new Timer(min, sec);
        Thread thread = new Thread(timer);
        thread.start();


        while (true) {
        System.out.println("Press Enter to stop Timer");
        String pause = scanner.nextLine();
            if (pause.isEmpty()) {
                Timer.stop();
                break;
            }
        }

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
