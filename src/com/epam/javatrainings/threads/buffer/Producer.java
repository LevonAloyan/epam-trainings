package com.epam.javatrainings.threads.buffer;

public class Producer<T> implements Runnable {
    BoundedBlockingBuffer<T> buffer;
    Producable<T> producable;

    public Producer(BoundedBlockingBuffer<T> buffer, Producable<T> producable) {
        this.buffer = buffer;
        this.producable = producable;
    }

    @Override
    public void run() {
        while (true) {
            buffer.put(producable.produce());
        }
    }
}
