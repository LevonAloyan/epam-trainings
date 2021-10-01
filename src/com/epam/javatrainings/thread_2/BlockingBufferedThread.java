package com.epam.javatrainings.thread_2;

public class BlockingBufferedThread<T> extends Thread {
    private final T t;
    private final BlockingBuffer<T> blockingBuffer;

    BlockingBufferedThread(T t, BlockingBuffer<T> blockingBuffer) {
        this.t = t;
        this.blockingBuffer = blockingBuffer;
    }

    @Override
    public void run() {
        blockingBuffer.put(t);
        blockingBuffer.take();
    }
}
