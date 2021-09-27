package com.epam.javatrainings.buffer;

public class BoundedBlockingBuffer<T> {
    private T data;
    private boolean dataInBuffer = false;

    public synchronized void put(T data) {
        while(dataInBuffer) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.data = data;
        dataInBuffer = true;
        System.out.println("Putting: " + this.data);
        notify();
    }

    public synchronized T take() {
        while(!dataInBuffer) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        dataInBuffer = false;
        notify();
        System.out.println("Taking: " + data);
        return data;
    }

}


