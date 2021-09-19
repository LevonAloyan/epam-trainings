package com.epam.javatrainings.threads.blockingBuffer;

public class BoundedBlockingBuffer<T> {
    private T data;

    public synchronized void put(T data) {
        if (this.data != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": put data -> " + data);
        this.data = data;
        notifyAll();
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void take() {
        if (this.data == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T data;
        data = this.data;
        this.data = null;
        System.out.println(Thread.currentThread().getName() + ": take data -> " + data);
        notifyAll();
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
