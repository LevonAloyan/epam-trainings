package com.epam.javatrainings.bounded_blocking_buffer.service;

public class BoundedBufferThread<T> extends Thread {
    private T value;
    private final BoundedBlockingBuffer<T> thread;

    public BoundedBufferThread(T value, BoundedBlockingBuffer<T> obj) {
        this.value = value;
        thread = obj;
    }

    @Override
    public void run() {
        thread.put(value);
        thread.take();
    }
}
