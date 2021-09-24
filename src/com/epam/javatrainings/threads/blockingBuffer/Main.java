package com.epam.javatrainings.threads.blockingBuffer;

public class Main {
    public static void main(String[] args) {
        BoundedBlockingBuffer<String> boundedBlockingBuffer = new BoundedBlockingBuffer<>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                    boundedBlockingBuffer.put("Erik");
            }
        }, "Thread 1");
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                    boundedBlockingBuffer.take();
            }
        }, "Thread 2");
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
