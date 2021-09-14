package com.epam.javatrainings.threads.buffer;

public class Consumer<T> implements Runnable {
    BoundedBlockingBuffer<T> buffer;

    public Consumer(BoundedBlockingBuffer<T> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            buffer.take();
        }
    }
}
