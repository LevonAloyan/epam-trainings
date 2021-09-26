package com.epam.javatrainings.blockingbuffer;

import java.util.ArrayDeque;
import java.util.Queue;

public class BoundedBlockingBuffer<T> {
    private final Queue<T> buffer;
    private final int capacity;

    public BoundedBlockingBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new ArrayDeque<>(capacity);
    }

    public synchronized void put(T t) {
        while (isFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        buffer.add(t);

        System.out.println(Thread.currentThread().getName() + " putes " + t);
        System.out.println(buffer);

        notifyAll();
    }

    public synchronized T take() {
        while (isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        T rv = buffer.poll();

        System.out.println(Thread.currentThread().getName() + " takes " + rv);
        System.out.println(buffer);

        notifyAll();
        return rv;
    }

    public boolean isEmpty() {
        return buffer.isEmpty();
    }

    public boolean isFull() {
        return buffer.size() == capacity;
    }
}
