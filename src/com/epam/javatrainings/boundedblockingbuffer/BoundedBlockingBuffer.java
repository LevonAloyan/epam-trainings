package com.epam.javatrainings.boundedblockingbuffer;

import java.util.ArrayDeque;
import java.util.Queue;

public class BoundedBlockingBuffer<T> {

    private final Queue<T> buffer;
    private final int capacity;
    private boolean isFull = false;

    public BoundedBlockingBuffer(int bufferSize) {
        buffer = new ArrayDeque<>(bufferSize);
        this.capacity = bufferSize;
    }

    public synchronized T take() {
        while (buffer.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        T t =  buffer.poll();
        isFull = false;
        notifyAll();
        return t;
    }

    public synchronized void put(T t) {
        while(isFull) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buffer.add(t);
        if(buffer.size()==capacity) {
            isFull=true;
        }
        notifyAll();
    }
}
