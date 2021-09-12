package com.epam.javatrainings.boundedblockingbuffer;

public class MyThread {
    public static void main(String[] args) {
        BoundedBlockingBuffer<String> boundedBlockingBuffer = new BoundedBlockingBuffer<>();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                boundedBlockingBuffer.put("Hello World");
            }
        });
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                boundedBlockingBuffer.put("Barev");
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                boundedBlockingBuffer.tack();

            }
        });

        thread.start();
        thread1.start();
        thread2.start();
    }
}
