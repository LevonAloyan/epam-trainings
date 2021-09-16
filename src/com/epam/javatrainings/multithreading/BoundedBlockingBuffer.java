package com.epam.javatrainings.multithreading;

import java.util.ArrayList;

public class BoundedBlockingBuffer<T> {

    private final Object[] buffer = new Object[1];
    private int len;

    public synchronized T take() {
        try {
            while (isEmpty()) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        T element = (T) buffer[0];
        len--;
        notifyAll();
        return element;
    }


    public synchronized void put(T data) {
        try {
            while (isFull()) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buffer[0] = data;
        len++;
        notifyAll();
    }


    public synchronized boolean isFull() {
        return len == buffer.length;
    }

    public synchronized boolean isEmpty() {
        return len == 0;
    }
}



