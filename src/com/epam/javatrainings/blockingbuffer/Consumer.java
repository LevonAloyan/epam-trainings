package com.epam.javatrainings.blockingbuffer;

public class Consumer<T> extends Thread {
    private final BoundedBlockingBuffer<T> buffer;

    public Consumer(String name, BoundedBlockingBuffer<T> buffer) {
        super(name);
        this.buffer = buffer;
        start();
    }

    @Override
    public void run() {
        while(true) {
            buffer.take();
        }
    }
}