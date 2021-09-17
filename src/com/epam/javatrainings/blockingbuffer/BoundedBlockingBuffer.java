package com.epam.javatrainings.blockingbuffer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public class BoundedBlockingBuffer<T> {
    private final Queue<T> buffer;
    private final int capacity;

    private AtomicBoolean finished = new AtomicBoolean(false);

    public BoundedBlockingBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new ArrayDeque<>(capacity);
    }

    public synchronized void put(T t) {
        if (t == null) {
            throw new NullPointerException();
        }

        while (isFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        buffer.add(t);

        System.out.println(Thread.currentThread().getName() + " puts " + t);
        System.out.println(buffer);

        notifyAll();
    }

    public synchronized T take() {
        while (isEmpty() && !isFinished().get()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (buffer.isEmpty()) {
            return null;
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

    public AtomicBoolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished.set(finished);
    }
}
