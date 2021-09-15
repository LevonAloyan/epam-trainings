package com.epam.javatrainings.multithreading;


public class BoundedBlockingBuffer<T> {
    private T data;

    public synchronized void put(T data) {
        if (this.data == null) {
            this.data = data;
            System.out.println("put " + data);
            notifyAll();
        } else {
            try {
                wait();
                put(data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public synchronized T pick() {

        if (data != null) {
            T t = data;
            data = null;
            System.out.print("Picked " + t);
            System.out.println(", data = " + data);
            notifyAll();
            return t;
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return pick();
        }
    }

}

