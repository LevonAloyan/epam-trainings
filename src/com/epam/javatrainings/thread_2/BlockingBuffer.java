package com.epam.javatrainings.thread_2;

public class BlockingBuffer<T> {
    private T data;
    private boolean isEmpty;

    public synchronized void put(T t) {
        String threadName = Thread.currentThread().getName();

        while (isEmpty) {
            System.out.println(threadName + " wait: buffer already contains some data");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(threadName + ": put : " + t);

        this.data = t;

        isEmpty = true;
        notifyAll();
    }

    public synchronized T take() {
        String threadName = Thread.currentThread().getName();

        while (!isEmpty) {
            System.out.println("Buffer doesn't contain some data: put");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(threadName + ": take : " + data);

        isEmpty = false;
        notifyAll();

        return data;
    }
}
