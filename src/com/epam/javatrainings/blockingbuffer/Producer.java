package com.epam.javatrainings.blockingbuffer;

import java.util.function.Supplier;

public class Producer<T> extends Thread {
    private final BoundedBlockingBuffer<T> buffer;
    private final Supplier<T> supplier;

    public Producer(String name, BoundedBlockingBuffer<T> buffer, Supplier<T> supplier) {
        super(name);
        this.buffer = buffer;
        this.supplier = supplier;
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            T value = supplier.get();
            buffer.put(value);
        }
    }
}
