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
        System.out.println(getName() + " starts");
        while(!buffer.isFinished().get() || !buffer.isEmpty()) {
            buffer.take();
        }
        System.out.println(getName() + " ends");
    }
}