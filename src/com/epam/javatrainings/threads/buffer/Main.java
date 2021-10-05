package com.epam.javatrainings.threads.buffer;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BoundedBlockingBuffer buffer = new BoundedBlockingBuffer();

        Producer producer = new Producer(buffer, () -> {
            String [] words = {"Hello", "Bounded", "Blocking", "Buffer"};

            return words[new Random().nextInt(4)];
        });

        // We can produce any type of data, by commenting out we can test integer's production
        // Producer producer = new Producer(buffer, () -> {
        //     return new Random().nextInt(10);
        // });

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The main thread is finished");
    }
}
