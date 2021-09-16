package com.epam.javatrainings.multithreading;

public class Solution2 {
    public static void main(String[] args) {
        Thread thread = new MyClockThread();
        thread.start();
    }
}
