package com.epam.javatrainings.homework_6;

import java.util.Arrays;

public class BufferTest {

    public static void main(String[] args) {
        Buffer <Integer> buffer = new Buffer<>();

        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                buffer.put(15);
            }
        });



        Thread producerThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                buffer.put(375);
            }
        });

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
               System.out.println(buffer.take());
            }
        });

        Thread consumerThread2 = new Thread(() -> {
                System.out.println(buffer.take());

        });

        producerThread.start();
        producerThread2.start();
        consumerThread.start();
        consumerThread2.start();
        try {
            producerThread.join();
            producerThread2.join();
            consumerThread.join();
            consumerThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished:");

    }


}
