package com.epam.javatrainings.threads.buffer;

public class BoundedBlockingBuffer<T> {
    private T data;
    private boolean dataIsSet;

    public synchronized T take() {
        String currentThreadName = Thread.currentThread().getName();
        while(!dataIsSet) {
            System.out.println(currentThreadName + " is waiting for a data");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(currentThreadName + " took the data " + data);
        dataIsSet = false;
        notifyAll();

        return data;
    }

    public synchronized void put(T data) {
        String currentThreadName = Thread.currentThread().getName();
        while(dataIsSet) {
            System.out.println(currentThreadName + " is waiting for data taking");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(currentThreadName + " put the data " + data + " in the buffer");
        this.data = data;
        dataIsSet = true;
        notifyAll();
    }
}
