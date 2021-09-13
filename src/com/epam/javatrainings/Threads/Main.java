package com.epam.javatrainings.Threads;

public class Main {
    public static void main(String[] args) {
        int minutes = TimerUtils.setTimer("Minutes");       //inputting minutes through scanner
        int seconds = TimerUtils.setTimer("Seconds");       //inputting seconds through scanner

        Timer timer = new Timer(minutes, seconds);          //calling the Timer thread

    }
}
